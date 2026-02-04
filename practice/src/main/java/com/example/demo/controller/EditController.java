package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.form.ContactForm;
import com.example.demo.service.ContactServiceImpl;

@Controller
public class EditController {
	@Autowired
	private ContactServiceImpl contactService;

	@GetMapping("/admin/contacts/{id}")
	public String displayEdit(@PathVariable Long id, Model model) {
		ContactDTO contactDto = contactService.getContactDto(id);

		ContactForm contactForm = new ContactForm();
		contactForm.setLastName(contactDto.getLastName());
		contactForm.setFirstName(contactDto.getFirstName());
		contactForm.setEmail(contactDto.getEmail());
		contactForm.setPhone(contactDto.getPhone());
		contactForm.setZipCode(contactDto.getZipCode());
		contactForm.setAddress(contactDto.getAddress());
		contactForm.setBuildingName(contactDto.getBuildingName());
		contactForm.setContactType(contactDto.getContactType());
		contactForm.setBody(contactDto.getBody());

		model.addAttribute("contactForm", contactForm);
		model.addAttribute("contactId", id);

		return "admin/contactEdit";
	}
}
