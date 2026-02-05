package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Admin;
import com.example.demo.dto.AdminDTO;
import com.example.demo.repository.AdminRepository;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	private AdminRepository adminRepository;


	@Override
	public void saveAdmin(AdminDTO dto) {
		Admin admin = dtoToEntity(dto);
		adminRepository.save(admin);
	}

	private Admin dtoToEntity(AdminDTO dto) {
		Admin admin = new Admin();
		admin.setLastName(admin.getLastName());
		admin.setFirstName(admin.getFirstName());
		admin.setEmail(admin.getEmail());
		admin.setPassword(admin.getPassword());
		return admin;
	}
}
