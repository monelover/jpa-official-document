package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.User;
import com.example.demo.services.UserService;

@RestController
public class UserController {
	@Autowired
	UserService userService;
	@PostMapping("/user")
	public User save(@RequestBody User reqUser) {
		User user = userService.add(reqUser);
		return user;
	}
}
