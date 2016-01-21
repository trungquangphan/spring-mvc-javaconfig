package com.doomphantoom.service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * Created by Trung on 12/21/2015.
 */
public class TokenHandler {
    private String secret="mysecret";

    private UserService userService;

    public TokenHandler(String secret,UserService userService) {
        this.secret=secret;
        this.userService = userService;
    }

    public UserDetails parseUserFromToken(String token) {
        String username = Jwts.parser()
        .setSigningKey(secret)
        .parseClaimsJws(token)
        .getBody()
        .getSubject();
        return userService.loadUserByUsername(username);
        }

    public String createTokenForUser(UserDetails user) {
       return Jwts.builder()
                 .setSubject(user.getUsername())
                 .signWith(SignatureAlgorithm.HS512, secret)
                 .compact();
     }
}
