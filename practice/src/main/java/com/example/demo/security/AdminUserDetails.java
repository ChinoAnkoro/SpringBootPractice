package com.example.demo.security;

import java.util.Collections;
import java.util.Collection;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import com.example.demo.entity.Admin;

public class AdminUserDetails implements UserDetails{
	private final Admin admin;
	
	private AdminUserDetails(Admin admin) {
		this.admin = admin;
	}
	
	public static AdminUserDetails from(Admin admin) {
		return new AdminUserDetails(admin);
	}
	
	@Override
	public String getUsername() {
		return admin.getEmail();
	}
	
	@Override
	public String getPassword() {
		return admin.getPassword();
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities(){
		return Collections.singleton(new SimpleGrantedAuthority("ROLE_ADMIN"));
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
