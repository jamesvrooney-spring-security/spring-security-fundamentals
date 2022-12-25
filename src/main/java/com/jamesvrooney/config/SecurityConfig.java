package com.jamesvrooney.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

//    @Bean
//    public UserDetailsService userDetailsService() {
//        final var userDetailsService = new InMemoryUserDetailsManager();
//
//        var james = User.withUsername("james")
//                .password(passwordEncoder().encode("password"))
//                .authorities("dude")
//                .build();
//
//        var john = User.withUsername("john")
//                .password(passwordEncoder().encode("password"))
//                .authorities("dudette")
//                .build();
//
//        userDetailsService.createUser(james);
//        userDetailsService.createUser(john);
//
//        return userDetailsService;
//    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
