package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.service.ContactService;

@Controller
public class AdminController {
	@Autowired
	private ContactService contactService;

	@GetMapping(value = "/admin/contacts")
	public String displayList(Model model) {
		model.addAttribute("contactList", contactService.getContactDtoList());
		return "admin/contactList";
	}

	
	
}
