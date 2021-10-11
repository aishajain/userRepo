package com.example.user.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.user.entities.User;
import com.example.user.service.UserService;

@RestController
public class UserController {
	@Autowired
	private UserService userService;

	@PostMapping(value = "/user")
	public User save(@RequestBody @Valid User user) {
		return userService.save(user);
	}

	@PutMapping(value = "/user")
	public User update(@RequestBody @Valid User user) {
		if (user.getUserId() == null) {
			throw new RuntimeException("UserId Cannot be null");
		}
		return userService.save(user);
	}

	@GetMapping(value = "/user/{userId}")
	public User getUserById(@PathVariable Integer userId) {
		return userService.getUserById(userId);
	}

	@DeleteMapping(value = "/user/{userId}")
	public void hardDelete(@PathVariable Integer userId) {
		userService.hardDelete(userId);
	}

	@DeleteMapping(value = "/user/softDelete/{userId}")
	public User softDelete(@PathVariable Integer userId) {
		return userService.softDelete(userId);
	}

	@GetMapping(value = "/user")
	public List<User> getAllUser() {
		return userService.getAllUser();
	}

	@GetMapping(value = "/user/sortByDOB")
	public List<User> findOrderByDOB() {
		return userService.findOrderByDOBAsc();
	}

	@GetMapping(value = "/user/sortByJoiningDt")
	public List<User> findOrderByJoiningDate() {
		return userService.findByOrderByJoiningDate();
	}

	@GetMapping(value = "/user/sortByDobAndJoiningDt")
	public List<User> findByOrderByDobAndJoiningDate() {
		return userService.findByOrderByDobAndJoiningDate();
	}

	@GetMapping(value = "/user/searchByNameOrSurnameOrPincode")
	public List<User> findByNameOrSurnameOrPincode(@RequestParam(defaultValue = "") String name,
			@RequestParam(defaultValue = "") String surname, @RequestParam(defaultValue = "0") Integer pincode) {
		return userService.findByNameOrSurnameOrPincode(name, surname, pincode);
	}
}
