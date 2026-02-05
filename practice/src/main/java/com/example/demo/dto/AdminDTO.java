package com.example.demo.dto;

import java.time.LocalDateTime;

import com.example.demo.entity.Admin;

import lombok.Data;

@Data
public class AdminDTO {
	public Long id;
	public String lastName;
	public String firstName;
	public String email;
	public String password;
	public LocalDateTime currentSignInAt;
	public LocalDateTime createdAt;
	public LocalDateTime updatedAt;
}
