package com.infinitynetwork.csit314.Security;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

public class CustomAuthenticationToken extends UsernamePasswordAuthenticationToken {
    private String domainGroup;

    // Constructor for unauthenticated token
    public CustomAuthenticationToken(Object principal, Object credentials, String domainGroup) {
        super(principal, credentials);
        this.domainGroup = domainGroup;
    }

    // Constructor for authenticated token
    public CustomAuthenticationToken(Object principal, Object credentials, String domainGroup,
                                     Collection<? extends GrantedAuthority> authorities) {
        super(principal, credentials, authorities);
        this.domainGroup = domainGroup;
    }

    public String getDomainGroup() {
        return domainGroup;
    }
}
