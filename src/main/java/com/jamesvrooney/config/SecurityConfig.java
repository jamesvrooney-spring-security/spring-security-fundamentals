package com.jamesvrooney.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity
                .httpBasic()
                .and()
                .authorizeHttpRequests()
                .requestMatchers("/hello").hasAuthority("read")
                .anyRequest().authenticated()
                .and()
                .build();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        final var userDetailsService = new InMemoryUserDetailsManager();

        final UserDetails john = User.withUsername("john")
                .password(passwordEncoder().encode("password"))
                .authorities("read")
                .build();

        final UserDetails bob = User.withUsername("bob")
                .password(passwordEncoder().encode("password"))
                .authorities("write")
                .build();

        userDetailsService.createUser(john);
        userDetailsService.createUser(bob);

        return userDetailsService;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
