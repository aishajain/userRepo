package com.example.user.entities;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "User")
@Data
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "UserId")
	private Integer userId;

	@Column(name = "Name", length = 25)
	@NotBlank(message = "Name Is Mandatory")
	private String name;

	@Column(name = "Surname", length = 25)
	@NotBlank(message = "Surname Is Mandatory")
	private String surname;

	@Column(name = "PinCode", length = 6)
	@NotNull(message = "PinCode Is Mandatory")
	private Integer pincode;

	@Column(name = "DOB")
	private Date dob;

	@Column(name = "JoiningDate")
	private Date joiningDate;

	@Column(name = "Flag")
	private Boolean flag = false;

	
}
