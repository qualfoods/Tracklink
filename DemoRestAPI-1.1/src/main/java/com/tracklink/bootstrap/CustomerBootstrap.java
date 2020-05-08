package com.tracklink.bootstrap;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.tracklink.model.Contact;
import com.tracklink.model.Customer;
import com.tracklink.repository.CustomerRepository;

@Component
public class CustomerBootstrap implements ApplicationListener<ContextRefreshedEvent>{

	@Autowired
	private final CustomerRepository customerRepository;
	
	public CustomerBootstrap(CustomerRepository customerRepository) {
		this.customerRepository =  customerRepository;
	}
	
	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		customerRepository.saveAll(getCustomers());
	}

	private List<Customer> getCustomers(){
		List<Customer> customers = new ArrayList<>(2);
		
		Customer customer = new Customer();
		customer.setName("Astrid");
		customer.setRegistration(123);
		customer.addContacts(new Contact("Hilda", "11111111"));
		customer.addContacts(new Contact("Rogerio", "2525255"));
		customer.addContacts(new Contact("Eric", "5566666"));

		Customer customer2 = new Customer();
		customer2.setName("Mariajose");
		customer2.setRegistration(123);
		customer2.addContacts(new Contact("Aldo", "5552222"));
		customer2.addContacts(new Contact("Edin", "966522"));
		customer2.addContacts(new Contact("Edith", "8282828"));

		customers.add(customer);
		customers.add(customer2);
		return customers;
	}
	
	
	
	
	
}
