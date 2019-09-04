package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import com.example.demo.models.User;

public interface UserService {
	List<User> listUsers();

	Optional<User> getById(long id);
	boolean saveUser(User user);
	boolean deleteUser(long id);
}
