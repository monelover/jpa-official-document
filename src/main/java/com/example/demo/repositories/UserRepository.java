package com.example.demo.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;

import com.example.demo.entities.User;

public interface UserRepository extends Repository<User, Long> , CrudRepository<User, Long>{
	// 규칙 지켜서 쿼리 만들기
	int countByLastname(String lastname);
	
	List<User> findDistinctUserByLastnameOrFirstname(String lastname, String firstname);

}
