package com.doomphantoom.filter;

import com.doomphantoom.service.DoomTokenAuthenticationService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * Created by Trung on 12/21/2015.
 */
public class StatelessAuthenticationFilter extends GenericFilterBean {
    private DoomTokenAuthenticationService doomTokenAuthenticationService;
    public StatelessAuthenticationFilter(DoomTokenAuthenticationService tokenAuthenticationService) {
        this.doomTokenAuthenticationService = tokenAuthenticationService;
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) servletRequest;
        Authentication authentication = doomTokenAuthenticationService.getAuthentication(httpRequest);
        SecurityContextHolder.getContext().setAuthentication(authentication);
        filterChain.doFilter(servletRequest, servletResponse);
        SecurityContextHolder.getContext().setAuthentication(null);
    }
}
