package com.example.demo.form;

import java.io.Serializable;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import com.example.demo.entity.Admin;

import lombok.Data;

@Data
public class AdminForm implements Serializable {
	private Long id;

	@NotBlank(message = "{NotBlank}")
	private String lastName;

	@NotBlank(message = "{NotBlank}")
	private String firstName;

	@NotBlank(message = "{NotBlank}")
	private String email;

	@NotBlank(message = "{NotBlank}")
	@Size(min = 8, max = 16)
	private String password;

	public AdminForm() {

	}

	public AdminForm(Admin admin) {
		this.id = admin.getId();
		this.lastName = admin.getLastName();
		this.firstName = admin.getFirstName();
		this.email = admin.getEmail();
		this.password = admin.getPassword();
	}
}
