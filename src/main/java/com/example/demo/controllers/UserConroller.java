package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.APIResponse;
import com.example.demo.models.User;
import com.example.demo.services.UserService;

@RequestMapping("/users")
@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
public class UserConroller {

	@Autowired
	UserService userService;

	@GetMapping
	public APIResponse getUsers() {
		List<User> users = userService.listUsers();
		return new APIResponse(HttpStatus.OK.value(), "List of users", users);
	}

	@PostMapping(path = "/create", consumes = "application/json")
	public APIResponse saveUser(@RequestBody User user) {
		return new APIResponse(HttpStatus.OK.value(), "User Created", userService.saveUser(user));
	}

	@GetMapping(path = "/{id}")
	public APIResponse getUserById(@PathVariable(name = "id") long id) {
		return new APIResponse(HttpStatus.OK.value(), "User fetched", userService.getById(id));
	}

	@DeleteMapping(path = "/{id}")
	public APIResponse deleteUserById(@PathVariable(name = "id") long id) {
		return new APIResponse(HttpStatus.OK.value(), "User Deleted", userService.deleteUser(id));
	}
}
