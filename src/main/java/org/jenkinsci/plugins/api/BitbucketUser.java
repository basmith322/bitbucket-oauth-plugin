package org.jenkinsci.plugins.api;

import org.acegisecurity.GrantedAuthority;
import org.acegisecurity.GrantedAuthorityImpl;
import org.acegisecurity.userdetails.UserDetails;
import org.apache.commons.lang.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class BitbucketUser implements UserDetails {

    private String username = StringUtils.EMPTY;

    private List<GrantedAuthority> grantedAuthorties = new ArrayList<>();

    public BitbucketUser() {
        super();
    }

    @Override
    public GrantedAuthority[] getAuthorities() {

        return grantedAuthorties.toArray(new GrantedAuthority[grantedAuthorties.size()]);
    }

    public void addAuthority(String role) {
        grantedAuthorties.add(new GrantedAuthorityImpl(role));
    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    public void setUserName(String username) {
        this.username = username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

}
