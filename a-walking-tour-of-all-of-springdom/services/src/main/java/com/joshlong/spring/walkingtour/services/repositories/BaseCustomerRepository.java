package com.joshlong.spring.walkingtour.services.repositories;

import java.math.BigInteger;
import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.joshlong.spring.walkingtour.services.model.Customer;

public interface BaseCustomerRepository 
	extends PagingAndSortingRepository<Customer, 
				BigInteger> {

    List<Customer> findByFirstName(String firstName);

    List<Customer> findByFirstName(String firstName, Pageable pageable);

    List<Customer> findByFirstNameAndLastName(String firstName, String lastName);

    List<Customer> findByFirstNameAndLastName(String firstName, String lastName, Pageable pageable);

}
