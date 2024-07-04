package com.vj.service;

import com.vj.entity.UserCredential;
import com.vj.repository.UserCredentialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private UserCredentialRepository userCredentialRepository ;

    @Autowired
    private PasswordEncoder passwordEncoder ;

    @Autowired
    private JwtService jwtService ;
    public String saveUser(UserCredential userCredential)
    {
        userCredential.setPassword(passwordEncoder.encode(userCredential.getPassword()));
        userCredentialRepository.save(userCredential) ;
        return "User Added to the system" ;
    }

    public String generateToken(String userName)
    {
        return jwtService.generateToken(userName);
    }

    public void validateToken(String token)
    {

        jwtService.validateToken(token);
    }
}
