package com.soundify.api.soundifyapi.controller;
import javax.validation.Valid;

import com.soundify.api.soundifyapi.model.User;
import com.soundify.api.soundifyapi.payloads.request.LoginRequest;
import com.soundify.api.soundifyapi.payloads.request.SignupRequest;
import com.soundify.api.soundifyapi.payloads.response.MessageResponse;
import com.soundify.api.soundifyapi.payloads.response.UserInfoResponse;
import com.soundify.api.soundifyapi.repository.UserRepository;
import com.soundify.api.soundifyapi.security.jwt.JwtUtils;
import com.soundify.api.soundifyapi.security.services.UserDetailsImpl;
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

import java.security.Principal;

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
    @PostMapping("/login")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {
        Authentication authentication = authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        ResponseCookie jwtCookie = jwtUtils.generateJwtCookie(userDetails);
        return ResponseEntity.ok().header(HttpHeaders.SET_COOKIE, jwtCookie.toString())
                .body(new UserInfoResponse(userDetails.getId(),
                        userDetails.getUsername(),
                        userDetails.getEmail()));
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
    /*public Map<String, Object> whoami(@AuthenticationPrincipal User user) {
        System.out.println(user);
        Map<String, Object> model = new HashMap<String, Object>();
        model.put("id", user.get_id());
        model.put("username", user.getUsername());
        model.put("playlist", user.getPlaylists());
        return model;
    }*/
    @ResponseBody
    public ResponseEntity<String> currentUserName(Authentication authentication) {
        //System.out.println(authentication.getName());
        //System.out.println(authentication.get);
        //System.out.println(authentication.getDetails());
        return ResponseEntity.ok().body(authentication.getName());
    }
}
