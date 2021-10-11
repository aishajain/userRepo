package com.example.user.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.user.entities.User;
import com.example.user.repository.UserRepository;
import com.example.user.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public User save(User user) {
		return userRepository.save(user);
	}

	@Override
	public User getUserById(Integer userId) {
		return userRepository.findByUserId(userId);
	}

	@Override
	public void hardDelete(Integer userId) {
		userRepository.deleteById(userId);

	}

	@Override
	public User softDelete(Integer userId) {
		User user = userRepository.findByUserId(userId);
		user.setFlag(true);
		return save(user);
	}

	@Override
	public List<User> getAllUser() {
		return userRepository.findAll();
	}

	@Override
	public List<User> findOrderByDOBAsc() {
		return userRepository.findByOrderByDobAsc();
	}

	@Override
	public List<User> findByOrderByJoiningDate() {
		return userRepository.findByOrderByJoiningDate();
	}

	@Override
	public List<User> findByOrderByDobAndJoiningDate() {
		return userRepository.findByOrderByDobAscJoiningDate();
	}

	@Override
	public List<User> findByNameOrSurnameOrPincode(String name, String surname, Integer pincode) {
		return userRepository.findByNameOrSurnameOrPincode(name, surname, pincode);
	}

}
