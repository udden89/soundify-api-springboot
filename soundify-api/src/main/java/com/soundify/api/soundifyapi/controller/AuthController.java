package com.soundify.api.soundifyapi.controller;
import javax.validation.Valid;



import com.soundify.api.soundifyapi.model.User;
import com.soundify.api.soundifyapi.payloads.request.LoginRequest;
import com.soundify.api.soundifyapi.payloads.request.SignupRequest;
import com.soundify.api.soundifyapi.payloads.response.MessageResponse;

import com.soundify.api.soundifyapi.security.jwt.JwtUtils;
import com.soundify.api.soundifyapi.security.services.AuthService;
import com.soundify.api.soundifyapi.security.services.UserDetailsImpl;
import com.soundify.api.soundifyapi.service.MapperService;
import com.soundify.api.soundifyapi.service.UserService;
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

@RestController
@RequestMapping("/api/user")
public class AuthController {
    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    UserService userService;
    @Autowired
    PasswordEncoder encoder;
    @Autowired
    JwtUtils jwtUtils;
    @Autowired
    MapperService mapperService;
    @Autowired
    AuthService authService;


    @PostMapping("/login")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {

        var jwtCookie = authService.setAuthentication(loginRequest.getUsername(), loginRequest.getPassword());
        var user = userService.findByUsername(loginRequest.getUsername());
        var userDTO = mapperService.UserToDTO(user);
        return ResponseEntity.ok().header(HttpHeaders.SET_COOKIE, jwtCookie.toString())
                .body(userDTO);
    }
    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequest signUpRequest) {
        if (userService.existsByUsername(signUpRequest.getUsername())) {
            return ResponseEntity.badRequest().body(new MessageResponse("Error: Username is already taken!"));
        }
        if (userService.existsByEmail(signUpRequest.getEmail())) {
            return ResponseEntity.badRequest().body(new MessageResponse("Error: Email is already in use!"));
        }

        User user = new User(signUpRequest.getUsername(),
                signUpRequest.getEmail(),
                encoder.encode(signUpRequest.getPassword()));

        userService.save(user);

        var jwtCookie = authService.setAuthentication(signUpRequest.getUsername(), signUpRequest.getPassword());

        return ResponseEntity.ok().header(HttpHeaders.SET_COOKIE, jwtCookie.toString()).body(new MessageResponse("User registered successfully!"));
    }
    @PostMapping("/logout")
    public ResponseEntity<?> logoutUser() {
        ResponseCookie cookie = jwtUtils.getCleanJwtCookie();
        return ResponseEntity.ok().header(HttpHeaders.SET_COOKIE, cookie.toString())
                .body(new MessageResponse("You've been signed out!"));
    }
    @GetMapping("/whoami")
    @ResponseBody
    public ResponseEntity<?>  currentUserName(Authentication authentication) {
        if(authentication == null)
            return ResponseEntity.ok().body(new MessageResponse("No user logged in"));
        var user = userService.findByUsername(authentication.getName());
        return ResponseEntity.ok().body(mapperService.UserToDTO(user));
    }
}
