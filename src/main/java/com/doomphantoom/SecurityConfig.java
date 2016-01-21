package com.doomphantoom;

import com.doomphantoom.filter.StatelessAuthenticationFilter;
import com.doomphantoom.service.DoomPasswordEncoder;
import com.doomphantoom.service.DoomTokenAuthenticationService;
import com.doomphantoom.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * Created by Trung on 12/21/2015.
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    private DoomTokenAuthenticationService tokenAuthenticationService;


    public SecurityConfig() {
        super(true);
        this.tokenAuthenticationService = new DoomTokenAuthenticationService("mysecret",new UserService());
    }

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.exceptionHandling().and()
                .anonymous().and()
                .servletApi().and()
                .headers().cacheControl().and()
                .and().authorizeRequests()
                // Allow anonymous resource requests
                .antMatchers("/").permitAll()
                .antMatchers("**/.html").permitAll()
                .antMatchers("**/.js").permitAll()
                .antMatchers("**/.css").permitAll()

                //Allow anonymous login
                .antMatchers("/unauth/**").permitAll()

                //All other requests need to be authenticated
                .anyRequest().authenticated().and().
                formLogin().loginPage("login").and().
                httpBasic().and().
                logout().and()
                .addFilterBefore(statelessAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);
    }


    @Bean
    protected StatelessAuthenticationFilter statelessAuthenticationFilter(){
        StatelessAuthenticationFilter statelessAuthenticationFilter= new StatelessAuthenticationFilter(tokenAuthenticationService);
        return statelessAuthenticationFilter;
    }


    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService()).passwordEncoder(new DoomPasswordEncoder());
    }

    @Bean
    @Override
    protected UserDetailsService userDetailsService() {
        return new UserService();
    }
}
