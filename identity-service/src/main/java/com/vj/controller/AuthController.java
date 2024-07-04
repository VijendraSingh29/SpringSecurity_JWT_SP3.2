package com.vj.controller;

import com.vj.dto.AuthRequest;
import com.vj.entity.UserCredential;
import com.vj.service.AuthService;
import com.vj.service.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    AuthService authService ;

    @Autowired
    AuthenticationManager authenticationManager ;

    @PostMapping("/register")
    public String saveUser(@RequestBody UserCredential userCredential)
    {
       return authService.saveUser(userCredential);
    }

    @PostMapping("/generateToken")
    public String generateToken(@RequestBody AuthRequest authRequest)
    {
        Authentication authenticate = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUserName(), authRequest.getPassword()));
        if(authenticate.isAuthenticated())
        return authService.generateToken(authRequest.getUserName()) ;
        else {
            throw new RuntimeException("Invalid access");
        }
    }

    @GetMapping("/validateToken")
    public String validateToken(@RequestParam String token)
    {
        authService.validateToken(token);
        return "Token is valid" ;
    }

    @GetMapping("/test")
    public String testMethod()
    {
        return "security test method is working " ;
    }
}
