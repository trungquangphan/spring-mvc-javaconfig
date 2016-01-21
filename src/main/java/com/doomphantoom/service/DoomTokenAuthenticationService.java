package com.doomphantoom.service;

import com.doomphantoom.dto.UserAuthentication;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Trung on 12/21/2015.
 */

public class DoomTokenAuthenticationService {
    private static final String AUTH_HEADER_NAME = "X-AUTH-TOKEN";
    private final TokenHandler tokenHandler;
    public DoomTokenAuthenticationService(String secret, UserService userService) {
        tokenHandler = new TokenHandler(secret, userService);
    }
    public Authentication getAuthentication(HttpServletRequest httpRequest) {
        final String token = httpRequest.getHeader(AUTH_HEADER_NAME);
        if(token!=null){
            final UserDetails user = tokenHandler.parseUserFromToken(token);
            if(user!=null){
                return new UserAuthentication((User)user);
            }
        }
        return null;
    }

    public String addAuthentication(HttpServletResponse response, UserDetails userDetail) {
        String token =tokenHandler.createTokenForUser(userDetail);
        response.addHeader(AUTH_HEADER_NAME, token);
        return token;
    }
}
