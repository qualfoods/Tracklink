package com.tracklink.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.tracklink.model.Customer;

public interface CustomerRepository extends MongoRepository<Customer, String> {

	Optional<Customer> findById(String id);
}
