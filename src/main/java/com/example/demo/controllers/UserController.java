package com.example.demo.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
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
	@GetMapping("/user/{id}")
	public User find(@PathVariable long id) {
		return userService.findById(id);
	}
	@GetMapping("/user/list")
	public Iterable<User> list() {
		return userService.list();
	}
	@GetMapping("/user/count")
	public int count() {
		return userService.count();
	}
	@DeleteMapping("/user")
	public void delete(@RequestBody User reqUser) {
		System.out.println("삭제");
		userService.delete(reqUser);
	}
	@GetMapping("/user/exist/{id}")
	public Boolean exist(@PathVariable long id) {
		return userService.exist(id);
	}
	@GetMapping("/user/name_c")
	public int countLastname(@RequestParam String name) {
		return userService.countByLastName(name);
	}
	@GetMapping("/user/f_name")
	public List<User> findDistinctUserByLastnameOrFirstname(@RequestBody User reqUser) {
		return userService.findDistinctUserByLastnameOrFirstname(reqUser);
	}
}
