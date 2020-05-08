package com.tracklink.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.tracklink.model.Customer;

public interface ContactRepository extends MongoRepository<Customer, String>{

}
