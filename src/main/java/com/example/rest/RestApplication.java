package com.example.rest;

import com.example.rest.security.MyAuthProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
@SpringBootApplication
public class RestApplication extends WebSecurityConfigurerAdapter {

    @Autowired
    private MyAuthProvider myAuthProvider;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.csrf().disable()
                .cors().disable()
                .httpBasic().disable()
                .authenticationProvider(myAuthProvider)
                .formLogin()
                .permitAll()
                .and()
                .authorizeRequests()
                .anyRequest().authenticated();
    }

    public static void main(String[] args) {
        SpringApplication.run(RestApplication.class, args);
    }
}
