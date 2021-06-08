package com.example.loginExample.service;

import com.example.loginExample.model.User;

public interface UserService {

	public void saveUser(User user);
	public boolean isUserAlreadyPresent(User user);
}
