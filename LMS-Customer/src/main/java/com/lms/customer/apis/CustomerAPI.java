package com.lms.customer.apis;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lms.customer.apis.model.Customer;
import com.lms.customer.dtos.CustomerDto;
import com.lms.customer.service.CustomerService;

@RestController

//http://localhost:8080/lms-customer/api
@RequestMapping("/api")
public class CustomerAPI {

	//List<CustomerDto> customers = new ArrayList<CustomerDto>();
	@Autowired CustomerService customerService;
	
	

	/**
	 * Get all customers list.
	 *
	 * @return the list
	 */
	@GetMapping("/customers")
	public ResponseEntity<List<CustomerDto>> getAllCustomers() {
		List<CustomerDto> customers = customerService.getCustomersAsDtos();
		return ResponseEntity.ok(customers);
	}

	/**
	   * Gets customer by id.
	   *
	   * @param customerId the customer Id
	   * @return the customer by id	   
	   */
	@GetMapping("/customers/{id}")
	public ResponseEntity<CustomerDto> getCustomerById(@PathVariable(value = "id") Long customerId) {
		CustomerDto customer = customerService.getCustomerById(customerId);
		return ResponseEntity.ok(customer);
	}
	
	/**
	   * Create user user.
	   *
	   * @param user the user
	   * @return the user
	   */
	  @PostMapping("/customer")
	  public ResponseEntity<CustomerDto> createCustomer(@Valid @RequestBody CustomerDto customer) {
		customerService.add(customer);
	    return ResponseEntity.ok(customer);
	  }


}
