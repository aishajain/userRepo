package com.example.user.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.user.entities.User;
import com.example.user.repository.UserRepository;
import com.example.user.service.impl.UserServiceImpl;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

	@Mock
	private UserRepository userRepository;

	@InjectMocks
	private UserServiceImpl userService;

	private User getUser() {
		return new User(1, "test", "test", 456123, Date.valueOf("1996-05-09"), Date.valueOf("2021-10-1"), false);
	}

	@Test
	void testSave() {
		User user = getUser();
		when(userRepository.save(Mockito.any())).thenReturn(user);
		User result = userService.save(user);
		assertEquals(user, result);
	}

	@Test
	void testGetUserById() {
		User user = getUser();
		when(userRepository.findByUserId(Mockito.anyInt())).thenReturn(user);
		User result = userService.getUserById(1);
		assertEquals(user, result);
	}

	@Test
	void testHardDelete() {
		userService.hardDelete(1);
		verify(userRepository, times(1)).deleteById(1);
	}

	@Test
	void testSoftDelete() {
		User user = getUser();
		when(userRepository.findByUserId(Mockito.anyInt())).thenReturn(user);
		userService.softDelete(1);
		assertEquals(true, user.getFlag());
	}

	@Test
	void testGetAllUsers() {
		List<User> users = new ArrayList<User>();
		users.add(getUser());
		when(userRepository.findAll()).thenReturn(users);
		List<User> result = userService.getAllUser();
		assertEquals(users, result);
	}

	@Test
	void testFindOrderByDOBAsc() {
		List<User> user = new ArrayList<User>();
		user.add(getUser());
		when(userRepository.findByOrderByDobAsc()).thenReturn(user);
		List<User> result = userService.findOrderByDOBAsc();
		assertEquals(user, result);
	}

	@Test
	void testFindByOrderByJoiningDate() {
		List<User> user = new ArrayList<User>();
		user.add(getUser());
		when(userRepository.findByOrderByJoiningDate()).thenReturn(user);
		List<User> result = userService.findByOrderByJoiningDate();
		assertEquals(user, result);
	}

	@Test
	void testFindByOrderByDobAndJoiningDate() {
		List<User> user = new ArrayList<User>();
		user.add(getUser());
		when(userRepository.findByOrderByDobAscJoiningDate()).thenReturn(user);
		List<User> result = userService.findByOrderByDobAndJoiningDate();
		assertEquals(user, result);
	}

	@Test
	void testFindByName() {
		List<User> user = new ArrayList<User>();
		user.add(getUser());
		when(userRepository.findByNameOrSurnameOrPincode(Mockito.any(), Mockito.any(), Mockito.any())).thenReturn(user);
		List<User> result = userService.findByNameOrSurnameOrPincode("test", "", 0);
		assertEquals(user, result);
	}

	@Test
	void testFindBySurname() {
		List<User> user = new ArrayList<User>();
		user.add(getUser());
		when(userRepository.findByNameOrSurnameOrPincode(Mockito.any(), Mockito.any(), Mockito.any())).thenReturn(user);
		List<User> result = userService.findByNameOrSurnameOrPincode("", "test", 0);
		assertEquals(user, result);
	}

	@Test
	void testFindByPincode() {
		List<User> user = new ArrayList<User>();
		user.add(getUser());
		when(userRepository.findByNameOrSurnameOrPincode(Mockito.any(), Mockito.any(), Mockito.any())).thenReturn(user);
		List<User> result = userService.findByNameOrSurnameOrPincode("", "", 456123);
		assertEquals(user, result);
	}

	@Test
	void testFindByNameOrSurnameOrPincode() {
		List<User> result = userService.findByNameOrSurnameOrPincode("", "", 0);
		assertTrue(result.isEmpty());
	}
}
