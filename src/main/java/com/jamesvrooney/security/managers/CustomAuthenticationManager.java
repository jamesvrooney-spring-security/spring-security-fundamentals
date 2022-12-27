package com.jamesvrooney.security.managers;

import com.jamesvrooney.security.providers.ApiKeyProvider;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

@AllArgsConstructor
public class CustomAuthenticationManager implements AuthenticationManager {

    private final String apiKey;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        ApiKeyProvider apiKeyProvider = new ApiKeyProvider(apiKey);

        if (apiKeyProvider.supports(authentication.getClass())) {
            return apiKeyProvider.authenticate(authentication);
        }

        return authentication;
    }
}
