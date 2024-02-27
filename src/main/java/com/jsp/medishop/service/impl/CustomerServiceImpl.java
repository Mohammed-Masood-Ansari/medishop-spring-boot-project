package com.jsp.medishop.service.impl;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.jsp.medishop.dao.CustomerDao;
import com.jsp.medishop.dto.Customer;
import com.jsp.medishop.response.ResponseStructure;
import com.jsp.medishop.service.CustomerService;
import com.jsp.medishop.verification.EmailPasswordVerification;

/**
 * @author Mo Masood Ansari
 *
 */
@SuppressWarnings("unused")
@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerDao dao;
	@Autowired
	private EmailPasswordVerification verification;
	@Autowired
	private ResponseStructure<Customer> structure;
	
	@Autowired
	private ResponseStructure<List<Customer>> structure2;

	@Override
	public ResponseStructure<Customer> saveCustomerService(Customer customer) {
		String email = verification.verifyEmail(customer.getEmail());
		String password = verification.verifyPassword(customer.getPassword());
		if (email != null) {
			if (password != null) {
				int currentYear = LocalDate.now().getYear();
				int customerDobYear = customer.getDob().getYear();
				int age = currentYear - customerDobYear;
				if (age >= 18) {
					dao.saveCustomerDao(customer);
					structure.setData(customer);
					structure.setMsg("Data Inserted!!!!");
					structure.setStatus(HttpStatus.CREATED.value());
				} else {
					structure.setData(null);
					structure.setMsg("you are not eligible your age is less than 18");
					structure.setStatus(HttpStatus.NOT_ACCEPTABLE.value());
				}

			} else {
				structure.setData(customer);
				structure.setMsg("Please check your password!!!!");
				structure.setStatus(HttpStatus.NOT_ACCEPTABLE.value());
			}
		} else {
			structure.setData(customer);
			structure.setMsg("Please check your email!!!!");
			structure.setStatus(HttpStatus.NOT_ACCEPTABLE.value());
		}
		return structure;
	}

	@Override
	public ResponseStructure<Customer> getCustomerByIdService(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseStructure<Customer> getCustomerByEmailService(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Customer> getCustomersService() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseStructure<List<Customer>> updateCustomerByEmailService(Customer customer) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseStructure<Customer> deleteCustomerByEmailService(String email) {
		return null;
	}

}
