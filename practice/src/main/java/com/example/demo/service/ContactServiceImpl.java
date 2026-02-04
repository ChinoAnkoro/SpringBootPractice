package com.example.demo.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.ContactDTO;
import com.example.demo.entity.Contact;
import com.example.demo.form.ContactForm;
import com.example.demo.repository.ContactRepository;

@Service
public class ContactServiceImpl implements ContactService {

	@Autowired
	private ContactRepository contactRepository;

	@Override
	public void saveContact(ContactForm contactForm) {
		Contact contact = new Contact();

		contact.setLastName(contactForm.getLastName());
		contact.setFirstName(contactForm.getFirstName());
		contact.setEmail(contactForm.getEmail());
		contact.setPhone(contactForm.getPhone());
		contact.setZipCode(contactForm.getZipCode());
		contact.setAddress(contactForm.getAddress());
		contact.setBuildingName(contactForm.getBuildingName());
		contact.setContactType(contactForm.getContactType());
		contact.setBody(contactForm.getBody());

		contactRepository.save(contact);
	}

	@Override
	public Contact findById(Long id) {
		return contactRepository.findById(id).get();
	}

	@Override
	public List<ContactDTO> getContactDtoList() {
		return contactRepository.findAll().stream().map(this::entityToDto).collect(Collectors.toList());
	}
	
	@Override
	public ContactDTO getContactDto(Long id) {
		Contact contact = contactRepository.findById(id).orElseThrow(() -> new RuntimeException("Contact not found"));
		return entityToDto(contact);
	}

	private ContactDTO entityToDto(Contact contact) {
		ContactDTO dto = new ContactDTO();
		dto.setId(contact.getId());
		dto.setLastName(contact.getLastName());
		dto.setFirstName(contact.getFirstName());
		dto.setEmail(contact.getEmail());
		dto.setPhone(contact.getPhone());
		dto.setZipCode(contact.getZipCode());
		dto.setAddress(contact.getAddress());
		dto.setBuildingName(contact.getBuildingName());
		dto.setContactType(contact.getContactType().toString());
		dto.setBody(contact.getBody());
		return dto;
	}
	
	public Contact findById(Long id) {
		return contactRepository.findById(id).get();
	}
}
