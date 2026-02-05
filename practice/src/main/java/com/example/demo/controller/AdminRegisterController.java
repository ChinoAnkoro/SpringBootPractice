package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.form.AdminForm;
import com.example.demo.service.AdminService;

@Controller
public class AdminRegisterController {
	
	@Autowired
	private AdminService adminService;
	@GetMapping(value = "/admin/signup")
	public String showRegister(Model model) {
		model.addAttribute("adminForm", new AdminForm());
		return "admin/signup";
	}

	@PostMapping(value = "/admin/signup")
	public String register(@Validated @ModelAttribute AdminForm adminForm, BindingResult result) {
		if (result.hasErrors()) {
			return "admin/signup";
		}
		adminService.saveAdmin(adminForm);

		return "redirect:/admin/completion";
	}

	@GetMapping(value = "/admin/completion")
	public String complete() {
		return "admin/completion";
	}
}
