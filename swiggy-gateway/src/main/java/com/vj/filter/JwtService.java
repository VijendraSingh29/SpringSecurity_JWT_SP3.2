package com.vj.filter;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Service;

import java.security.Key;

@Service
public class JwtService {
    private final String secret = "5367566B59703373367639792F423F4528482B4D6251655468576D5A71347437" ;

    public void validateToken(final String token)
    {
        Jwts.parserBuilder().setSigningKey(getSignKey()).build().parseClaimsJws(token) ;

    }
    public Key getSignKey()
    {
        byte [] keyBytes = Decoders.BASE64.decode(secret) ;
        return Keys.hmacShaKeyFor(keyBytes) ;
    }
}

