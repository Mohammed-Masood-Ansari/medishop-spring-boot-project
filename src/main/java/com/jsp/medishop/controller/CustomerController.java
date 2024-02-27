package com.jsp.medishop.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.jsp.medishop.dto.Customer;
import com.jsp.medishop.response.ResponseStructure;
import com.jsp.medishop.service.CustomerService;
/**
 * 
 * @author Mo Masood Ansari
 *
 */
@RestController
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	private CustomerService service;

	@PostMapping(value = "/saveCustomer")
	public ResponseStructure<Customer> saveCustomerController(@RequestBody Customer customer) throws IOException {
//		System.out.println("image wala controller!!!!!!!!!!!");
//		customer.setImage(multipartFile.getBytes());
		return service.saveCustomerService(customer);
	}

}
