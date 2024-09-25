package com.sonu.customer.controller;

import com.sonu.customer.beans.request.AuthRequest;
import com.sonu.customer.util.JwtTokenUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/authenticate")
public class AuthController {

    private final JwtTokenUtil jwtTokenUtil;
    private final AuthenticationManager authenticationManager;

    @PostMapping("/generate-token")
    public String getTokenForAuthenticatedUser(@RequestBody AuthRequest authRequest) {
        Authentication authentication = authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUserName(), authRequest.getPassword()));
        if (authentication.isAuthenticated()) {
            return jwtTokenUtil.generateToken(authRequest.getUserName());
        } else {
            throw new RuntimeException("Invalid user credentials");
        }
    }

    @GetMapping(value = "/validate-token")
    public String validateToken() {
        return "Success";
    }
}