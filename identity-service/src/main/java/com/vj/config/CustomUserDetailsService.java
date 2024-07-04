package com.vj.config;

import com.vj.entity.UserCredential;
import com.vj.repository.UserCredentialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Optional;

public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    UserCredentialRepository userCredentialRepository ;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Optional<UserCredential> credential = userCredentialRepository.findByName(username);

       return credential.map(CustomUserDetails::new).orElseThrow(()-> new UsernameNotFoundException("user not found with user name " + username));
    }
}
