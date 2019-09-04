package com.example.demo.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.services.UserService;

@Service(value = "userService")
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;

	@Override
	public List<User> listUsers() {
		List<User> users = new ArrayList<User>();
		userRepository.findAll().iterator().forEachRemaining(users::add);
		for (User u : userRepository.findAll()) {
			System.out.println("u=" + u.getAge());
		}
		return users;
	}

	@Override
	public boolean saveUser(User user) {
		boolean success = false;
		try {
			userRepository.save(user);
			success = true;
		} catch (Exception e) {
			e.printStackTrace();
			success = false;
		}
		return success;
	}

	@Override
	public Optional<User> getById(long id) {
		// TODO Auto-generated method stub
		return userRepository.findById(id);
	}

	@Override
	public boolean deleteUser(long id) {
		boolean result = false;
		try {
			userRepository.deleteById(id);
			result = true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return result;
	}

}
