package com.tracklink.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tracklink.model.Customer;
import com.tracklink.repository.ContactRepository;
import com.tracklink.repository.CustomerRepository;

@RestController
//@RequestMapping("/cliente")
public class CustomerController {

	    @Autowired
	    CustomerRepository customerRepository;
	    @Autowired
	    ContactRepository ContactRepository;
	    
	    @RequestMapping(method=RequestMethod.GET)
	    public Iterable<Customer> customer() {
	    	
	    	customerRepository.findAll()
	    	.forEach(a -> System.out.println(a.getContacts()));
	    	
	        return customerRepository.findAll();
	    }

	    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	    public Customer create(@RequestBody Customer customer) {
	        return customerRepository.save(customer);
	    }

	    @RequestMapping(method=RequestMethod.GET, value = "/{id}")
	    public Optional<Customer> read(@PathVariable String id) {
	        return customerRepository.findById(id);
	    }

	    @RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	    public void update(@RequestBody Customer customer) {
	    	customerRepository.save(customer);
	    }

	    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE) 
	    public void delete(@PathVariable String id) {
	    	Customer st = new Customer();
	    	st.setId(id);
	    	customerRepository.delete(st); 
	    }
	 

	    
	    
}
