package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.dto.ContactDTO;
import com.example.demo.form.ContactForm;
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

	@GetMapping(value = "/admin/contacts/{id}/detail")
	public String displayView(@PathVariable Long id, Model model) {
		ContactDTO contactDto = contactService.getContactDto(id);
		model.addAttribute("contactData", contactDto);
		return "admin/contactDetail";
	}

	@GetMapping("/admin/contacts/{id}/edit")
	public String displayEdit(@PathVariable Long id, Model model) {
		ContactDTO contactDto = contactService.getContactDto(id);

		ContactForm contactForm = new ContactForm();
		contactForm.setId(contactDto.getId());
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
	
	@PostMapping("/admin/contacts/{id}/edit")
	public String update(
	        @PathVariable Long id,
	        @Validated @ModelAttribute ContactForm contactForm,
	        BindingResult result,
	        Model model) {

	    if (result.hasErrors()) {
	        model.addAttribute("contactId", id);
	        return "admin/contactEdit";
	    }

	    contactService.update(id, contactForm);
	    return "redirect:/admin/contacts";
	}
	
	@PostMapping("/admin/contacts/{id}/delete")
	public String contactDelete(@PathVariable Long id) {
		contactService.deleteById(id);
		return "redirect:/admin/contacts";
	}
}
