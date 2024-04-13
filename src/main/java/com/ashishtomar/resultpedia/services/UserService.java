package com.ashishtomar.resultpedia.services;


import com.ashishtomar.resultpedia.exceptions.UserNotFoundException;
import com.ashishtomar.resultpedia.models.User;
import com.ashishtomar.resultpedia.repositories.UserRepository;
import com.ashishtomar.resultpedia.security.JwtUtils;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserService {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtils jwtUtils;

    @Autowired
    private UserRepository userRepository;


    public boolean existsByEmail(String email) {
        return userRepository.existsByEmail(email);
    }



    public User findById(String id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("No User found with the given ID: " + id));

        return user;
    }


    public void save(User user) {
        userRepository.save(user);
    }


    public String loginUser(String email, String password) throws BadCredentialsException {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(email, password));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateJwtToken(authentication);

        return jwt;
    }


    public User getUserFromJwt(HttpServletRequest request) {
        String authorizationHeader = request.getHeader("Authorization");
        String token ="";
        if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
            token = authorizationHeader.substring(7);
        } else {
            throw new RuntimeException("Invalid Jwt Token");
        }

        User user = findById(jwtUtils.getIdFromJwtToken(token));
        return user;
    }

}
