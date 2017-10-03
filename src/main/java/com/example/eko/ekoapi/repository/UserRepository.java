package com.example.eko.ekoapi.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.eko.ekoapi.model.User;


//This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
//CRUD refers Create, Read, Update, Delete
public interface UserRepository extends CrudRepository<User, Long>{
	public User findByEmail(String email);
	public User findByName(String name);
}
