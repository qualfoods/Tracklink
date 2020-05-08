package com.tracklink.model;
import java.util.HashSet;
import java.util.Set;

//package com.volmar.demorestapi.model
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Customer {

	@Id
	private String id;
	private String name;
	private Integer registration;
	@DBRef
	Set<Contact> contacts = new HashSet<>();

	public Customer() {
	};

	public Customer(/*String id,*/ Integer registration, String name) {
		super();
		//this.id = id;
		this.registration = registration;
		this.name = name;
	}
	
	public Customer(String name) {
		super();
		this.name = name;
	}

	public Customer addContacts(Contact contact) {
		this.contacts.add(contact);
		return this;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Integer getRegistration() {
		return registration;
	}

	public void setRegistration(Integer registration) {
		this.registration = registration;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Contact> getContacts() {
		return contacts;
	}

	public void setContacts(Set<Contact> contacts) {
		this.contacts = contacts;
	}

	
	
}
