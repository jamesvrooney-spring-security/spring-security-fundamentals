package com.jamesvrooney.security;

import com.jamesvrooney.entities.Authority;
import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

@AllArgsConstructor
public class SecurityAuthority implements GrantedAuthority {

    private final Authority authority;

    @Override
    public String getAuthority() {
        final SimpleGrantedAuthority grantedAuthority = new SimpleGrantedAuthority(authority.getName());

        return grantedAuthority.getAuthority();
    }
}
