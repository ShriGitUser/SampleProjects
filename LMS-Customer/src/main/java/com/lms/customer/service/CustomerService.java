package com.lms.customer.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lms.customer.apis.model.Customer;
import com.lms.customer.apis.repositories.CustomerRepository;
import com.lms.customer.dtos.CustomerDto;
import com.lms.customer.enums.CustomerType;

@Component
public class CustomerService {
	@Autowired CustomerRepository customerRepository;
	
	public void add(CustomerDto dto) {
		customerRepository.save(toEntity(dto));
    }
    public void delete(long id) {
    	customerRepository.deleteById(id);
    }
    public List<Customer> getCustomers() {
        return (List<Customer>) customerRepository.findAll();
    }
    
    public List<CustomerDto> getCustomersAsDtos() {
    	List<Customer> customers =  (List<Customer>) customerRepository.findAll();
    	List<CustomerDto> customersDto = customers.stream().map(customer -> this.toDto(customer))
    	.collect(Collectors.toList());
    	return customersDto;
    }
    
    public CustomerDto getCustomerById(long id) {
        Optional<Customer> optionalDog = customerRepository.findById(id);
        CustomerDto customerDto = this.toDto(optionalDog.get());
        return customerDto;
    }
    private Customer toEntity(CustomerDto dto) {
    	Customer entity = new Customer();
        entity.setFirstName(dto.getFirstName());   
        entity.setMiddleName(dto.getMiddleName());           
        entity.setLastName(dto.getLastName());   
        entity.setCustomerType(dto.getCustomerType().name());           
        return entity;
    }
    
    private CustomerDto toDto(Customer entity) {
    	CustomerDto dto = new CustomerDto();
        dto.setFirstName(entity.getFirstName());   
        dto.setMiddleName(entity.getMiddleName());           
        dto.setLastName(entity.getLastName());   
        dto.setCustomerType(CustomerType.valueOf(entity.getCustomerType()));           
        return dto;
    }
	
	

}
