package com.example.user.service;

import java.util.List;

import com.example.user.entities.User;

public interface UserService {
	User save(User user);
	User getUserById(Integer userId);
	void hardDelete(Integer userId);
	User softDelete(Integer userId);
	List<User> getAllUser();
	List<User> findOrderByDOBAsc();
	List<User> findByOrderByJoiningDate();
	List<User> findByOrderByDobAndJoiningDate();
	List<User> findByNameOrSurnameOrPincode(String name, String surname, Integer pincode);
}
