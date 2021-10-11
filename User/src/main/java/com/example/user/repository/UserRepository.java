package com.example.user.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.user.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

	User findByUserId(Integer userId);
	List<User> findByOrderByDobAsc();
	List<User> findByOrderByJoiningDate();
	List<User> findByOrderByDobAscJoiningDate();
	List<User> findByNameOrSurnameOrPincode(String name, String surname, Integer pincode);

}
