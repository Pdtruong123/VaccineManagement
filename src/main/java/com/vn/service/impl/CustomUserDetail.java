package com.vn.service.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.vn.model.Customer;
import com.vn.model.Roles;
import com.vn.model.UserRole;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class CustomUserDetail implements UserDetails {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Customer customer;
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		
			List<UserRole> listUserRoles = customer.getUserRoles();
			for (UserRole userRole : listUserRoles) {
				System.out.println(userRole.getId());
			}
			List<SimpleGrantedAuthority> authorities = listUserRoles.stream().map(ur -> {
				Roles role = ur.getRole();
				String name = role.getRole();
				
				SimpleGrantedAuthority authority = new SimpleGrantedAuthority(name);
				return authority;
			}).collect(Collectors.toList());
			return authorities;
	}

	@Override
	public String getPassword() {
		return customer.getPassword();
	}

	@Override
	public String getUsername() {
		return customer.getUserName();
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
