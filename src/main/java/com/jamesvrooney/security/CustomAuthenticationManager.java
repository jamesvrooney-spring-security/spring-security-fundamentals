package com.jamesvrooney.security;

import com.jamesvrooney.security.providers.CustomAuthenticationProvider;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class CustomAuthenticationManager implements AuthenticationManager {

    private final CustomAuthenticationProvider customAuthenticationProvider;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {

        if (customAuthenticationProvider.supports(authentication.getClass())) {
            return customAuthenticationProvider.authenticate(authentication);
        } // other possible providers

        throw new BadCredentialsException("Oh no.");
    }
}
