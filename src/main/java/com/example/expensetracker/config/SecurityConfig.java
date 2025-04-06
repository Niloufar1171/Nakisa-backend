package com.example.expensetracker.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod; // <-- Import HttpMethod
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .csrf().disable() // Disable CSRF
            .headers().frameOptions().sameOrigin() // Allow frames for H2 console
            .and()
            .authorizeRequests()
            .antMatchers("/h2-console/**").permitAll()
            .antMatchers(HttpMethod.OPTIONS, "/api/**").permitAll() // Allow CORS preflight requests
            .antMatchers("/api/expenses/**").authenticated()
            .anyRequest().authenticated()
            .and()
            .httpBasic();
    }
}
