package com.lms.customer.apis.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lms.customer.apis.model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository <Customer, Long> {

}
