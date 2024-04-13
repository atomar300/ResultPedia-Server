package com.ashishtomar.resultpedia.controllers;

import com.ashishtomar.resultpedia.dto.UserResponse;
import com.ashishtomar.resultpedia.models.User;
import com.ashishtomar.resultpedia.security.JwtUtils;
import com.ashishtomar.resultpedia.services.UserService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Map;


@RestController
@RequestMapping("/api/v1")
@CrossOrigin
public class AuthController {


    @Autowired
    private PasswordEncoder encoder;

    @Autowired
    private JwtUtils jwtUtils;

    @Autowired
    private UserService userService;





    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody Map<String, String> payload) throws BadCredentialsException {
        String jwt = userService.loginUser(payload.get("email"), payload.get("password"));

        User user = userService.findById(jwtUtils.getIdFromJwtToken(jwt));

        UserResponse response = new UserResponse();
        response.setUser(user);
        response.setToken(jwt);

        return ResponseEntity.ok().body(response);
    }


    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody User user) throws Exception {
        if (userService.existsByEmail(user.getEmail())) {
            throw new Exception("Email is already taken!");
        }

        // encrypting user password before saving to the database
        String password = user.getPassword();
        user.setPassword(encoder.encode(user.getPassword()));

        // saving the user to the database
        userService.save(user);

        // Sending jwt token without having to login
        String jwt = userService.loginUser(user.getEmail(), password);

        UserResponse response = new UserResponse();
        response.setUser(user);
        response.setToken(jwt);

        return ResponseEntity.ok().body(response);
    }


    @GetMapping("/logout")
    public ResponseEntity<?> logoutUser() {

        // Setting the security context to null
        SecurityContextHolder.getContext().setAuthentication(null);

        return ResponseEntity.ok().body("User logged out!");
    }


    @GetMapping("/me")
    public ResponseEntity<UserResponse> getUserDetails(HttpServletRequest request) {

        User user = userService.getUserFromJwt(request);

        UserResponse response = new UserResponse();
        response.setUser(user);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }


}
