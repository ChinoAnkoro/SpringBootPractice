package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.entity.Contact;
import com.example.demo.service.ContactServiceImpl;

@Controller
public class AdminController {
	@Autowired
	private ContactServiceImpl contactServiceImpl;
	
	@GetMapping(value = "/admin/contacts")
	public String displayList(Model model) {
		List<Contact> contactList = contactServiceImpl.searchAll();
		model.addAttribute("contactList",contactList);
		return "admin/contactList";
	}
}
