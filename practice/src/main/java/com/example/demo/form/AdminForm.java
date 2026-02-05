package com.example.demo.form;

import java.io.Serializable;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import com.example.demo.dto.AdminDTO;
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

	public AdminForm(AdminDTO dto) {
		this.id = dto.getId();
		this.lastName = dto.getLastName();
		this.firstName = dto.getFirstName();
		this.email = dto.getEmail();
		this.password = dto.getPassword();
	}

	public AdminDTO formToDto() {
		AdminDTO dto = new AdminDTO();
		dto.setLastName(this.lastName);
		dto.setFirstName(this.firstName);
		dto.setEmail(this.email);
		dto.setPassword(this.password);
		return dto;
	}
}
