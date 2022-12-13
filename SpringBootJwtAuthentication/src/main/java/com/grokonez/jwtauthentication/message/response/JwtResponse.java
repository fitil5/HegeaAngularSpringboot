package com.grokonez.jwtauthentication.message.response;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;

public class JwtResponse {
	private String token;
	

	private String type = "Bearer";
	private String username;
	private Collection<? extends GrantedAuthority> authorities;
	private String name;
public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

private boolean enabled;
	public JwtResponse(String token, String username, Collection<? extends GrantedAuthority> authorities, boolean enabled,String name) {
	super();
	this.token = token;
	this.username = username;
	this.authorities = authorities;
	this.enabled = enabled;
	this.name=name;
}

	public JwtResponse(String accessToken, String username, Collection<? extends GrantedAuthority> authorities) {
		this.token = accessToken;
		this.username = username;
		this.authorities = authorities;
	}

	public String getAccessToken() {
		return token;
	}

	public void setAccessToken(String accessToken) {
		this.token = accessToken;
	}

	public String getTokenType() {
		return type;
	}

	public void setTokenType(String tokenType) {
		this.type = tokenType;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
}