package com.sapiens.bdms.security.api.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
@Order(2)
public class SpringSecurityConfigNoAuth extends WebSecurityConfigurerAdapter {

    @Autowired
    private CustomAuthenticationProvider customAuthenticationProvider;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        System.out.println(auth.hashCode() + " No Auth");
        auth.authenticationProvider(customAuthenticationProvider);
        auth.inMemoryAuthentication().withUser("user").password("pwd").roles("USER");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.antMatcher("/guest/**").authorizeRequests().anyRequest().fullyAuthenticated().and().httpBasic();
    }
}
