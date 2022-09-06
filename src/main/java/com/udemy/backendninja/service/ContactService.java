package com.udemy.backendninja.service;

import java.util.List;

import com.udemy.backendninja.model.ContactModel;
import com.udemy.backendninja.entity.Contact;

public interface ContactService {

		public abstract ContactModel addContact(ContactModel contactModel);
		
		public abstract List<ContactModel> listAllContacts();
		
		public abstract Contact findContactById(int id);
		
		public abstract void removeContact(int id);
		
		public abstract ContactModel findContacModeltById(int id);
}
