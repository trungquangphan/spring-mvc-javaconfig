//package com.doomphantoom.filter;
//
//import com.doomphantoom.service.DoomTokenAuthenticationService;
//import com.doomphantoom.service.UserService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
//import org.springframework.stereotype.Component;
//
///**
// * Created by Trung on 12/21/2015.
// */
//@Component("customBasicAuthFilter")
//public class CustomBasicAuthenticationFilter extends BasicAuthenticationFilter {
//
//    @Autowired
//    public CustomBasicAuthenticationFilter(AuthenticationManager authenticationManager) {
//        super(authenticationManager);
//    }
//
//    protected void onSuccessfulAuthentication(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response, Authentication authResult) {
//        DoomTokenAuthenticationService doomTokenAuthenticationService = new DoomTokenAuthenticationService("mysecret", new UserService());
//        if (authResult instanceof UserDetails) {
//            UserDetails userDetails = (UserDetails) authResult;
//            doomTokenAuthenticationService.addAuthentication(response, userDetails);
//        }
//    }
//}