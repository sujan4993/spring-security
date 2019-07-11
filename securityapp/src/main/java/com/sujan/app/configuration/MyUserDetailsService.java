package com.sujan.app.configuration;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.sujan.app.entity.User;
import com.sujan.app.repository.UserRepository;
@Service
public class MyUserDetailsService implements UserDetailsService {

	@Autowired
	private UserRepository repository;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		User user =repository.findByUsername(username);
		if(user==null)
			throw new UsernameNotFoundException("404 Error");
		
		return new UserDetailImplementation(user);
	}

}
