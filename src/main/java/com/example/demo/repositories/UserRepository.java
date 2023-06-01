package com.example.demo.repositories;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.entities.User;

public interface UserRepository extends CrudRepository<User, Long>{
	// 규칙 지켜서 쿼리 만들기
	int countByLastname(String lastname);

}
