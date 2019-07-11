package com.sujan.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sujan.app.entity.User;

public interface UserRepository extends JpaRepository<User,Long> {
	
	User findByUsername(String username);

}
