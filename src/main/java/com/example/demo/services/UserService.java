package com.example.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.User;
import com.example.demo.repositories.UserRepository;

@Service
public class UserService {
	@Autowired
	UserRepository userRepository;
	public User add(User reqUser) {
		return userRepository.save(reqUser);
	}
	
	public User findById(long id) {
		return userRepository.findById(id).orElseThrow(()-> {
			return new IllegalArgumentException(id + "의 유저는 존재하지 않습니다.");
		});
	}
	
	public Iterable<User> list() {
		return userRepository.findAll();
	}

	public int count() {
		return (int) userRepository.count();
	}

	public void delete(User reqUser) {
		userRepository.delete(reqUser);
		//잘 안쓸듯..
	}

	public Boolean exist(long id) {
		return userRepository.existsById(id);
	}
	public int countByLastName(String lastname) {
		return userRepository.countByLastname(lastname);
	}

}
