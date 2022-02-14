package com.soundify.api.soundifyapi.controller;
import javax.validation.Valid;


import com.soundify.api.soundifyapi.dto.UserDTO;
import com.soundify.api.soundifyapi.model.User;
import com.soundify.api.soundifyapi.payloads.request.LoginRequest;
import com.soundify.api.soundifyapi.payloads.request.SignupRequest;
import com.soundify.api.soundifyapi.payloads.response.MessageResponse;
import com.soundify.api.soundifyapi.repository.UserRepository;
import com.soundify.api.soundifyapi.security.jwt.JwtUtils;
import com.soundify.api.soundifyapi.security.services.UserDetailsImpl;
import com.soundify.api.soundifyapi.service.MapperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/user")
public class AuthController {
    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    UserRepository userRepository;
    @Autowired
    PasswordEncoder encoder;
    @Autowired
    JwtUtils jwtUtils;
    @Autowired
    MapperService mapperService;


    @PostMapping("/login")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {
        Authentication authentication = authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        ResponseCookie jwtCookie = jwtUtils.generateJwtCookie(userDetails);
        var user = userRepository.findByUsername(userDetails.getUsername());
        var userDTO = mapperService.UserToDTO(user);
        return ResponseEntity.ok().header(HttpHeaders.SET_COOKIE, jwtCookie.toString())
                .body(userDTO);
    }
    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequest signUpRequest) {
        System.out.println("register");
        if (userRepository.existsByUsername(signUpRequest.getUser_name())) {
            return ResponseEntity.badRequest().body(new MessageResponse("Error: Username is already taken!"));
        }
        if (userRepository.existsByEmail(signUpRequest.getEmail())) {
            return ResponseEntity.badRequest().body(new MessageResponse("Error: Email is already in use!"));
        }
        // Create new user's account
        User user = new User(signUpRequest.getUser_name(),
                signUpRequest.getEmail(),
                encoder.encode(signUpRequest.getPassword()));

        userRepository.save(user);
        return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
    }
    @PostMapping("/logout")
    public ResponseEntity<?> logoutUser() {
        ResponseCookie cookie = jwtUtils.getCleanJwtCookie();
        return ResponseEntity.ok().header(HttpHeaders.SET_COOKIE, cookie.toString())
                .body(new MessageResponse("You've been signed out!"));
    }
    @GetMapping("/whoami")
    @ResponseBody
    public UserDTO currentUserName(Authentication authentication) {
        var user = userRepository.findByUsername(authentication.getName());
        var userDTO = mapperService.UserToDTO(user);
        System.out.println(userDTO);
        return userDTO;
    }
}
