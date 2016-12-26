package com.bogdan.domain.security;

import org.springframework.security.core.GrantedAuthority;

/**
 * Created by zoomout on 12/26/16.
 */
public class Authority implements GrantedAuthority{

    private final String authority;

    public Authority(String authority){
        this.authority = authority;
    }

    @Override
    public String getAuthority() {
        return authority;
    }
}
