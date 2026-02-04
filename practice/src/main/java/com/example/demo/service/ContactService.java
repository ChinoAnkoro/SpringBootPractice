package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.ContactDTO;
import com.example.demo.entity.Contact;
import com.example.demo.form.ContactForm;


public interface ContactService {
	void saveContact(ContactForm contactForm);
	void update(Long id, ContactForm contactForm);
	void deleteById(Long id);
	
	Contact findById(Long id);
	List<ContactDTO> getContactDtoList();
	ContactDTO getContactDto(Long id);
}
