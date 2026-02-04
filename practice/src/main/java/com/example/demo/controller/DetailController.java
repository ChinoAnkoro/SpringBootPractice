package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.entity.Contact;
import com.example.demo.service.ContactServiceImpl;

@Controller
public class DetailController {
	@Autowired
	private ContactServiceImpl contactService;
	@GetMapping(value = "/admin/contacts/{id}")
	public String displayView(@PathVariable Long id, Model model) {
		Contact contact = contactService.findById(id);
		model.addAttribute("contactData", contact);
		return "admin/contactDetail";
	}
}
