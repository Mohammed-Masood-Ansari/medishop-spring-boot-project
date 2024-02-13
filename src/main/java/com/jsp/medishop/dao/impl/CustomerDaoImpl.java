package com.jsp.medishop.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.medishop.dao.CustomerDao;
import com.jsp.medishop.dto.Customer;
import com.jsp.medishop.repository.CustomerRepository;

@Repository
public class CustomerDaoImpl implements CustomerDao {

	@Autowired
	private CustomerRepository customerRepository;
	
	@Override
	public Customer saveCustomerDao(Customer customer) {
		return customerRepository.save(customer);
	}

	@Override
	public Customer getCustomerByIdDao(int customerId) {
		
		return null;
	}

	@Override
	public List<Customer> getAllCustomerDao() {
		return null;
	}

	@Override
	public Customer getCustomerByEmailDao(String customerEmail) {
		return null;
	}

	@Override
	public Customer updateCustomerByEmailDao(Customer customer) {
		return null;
	}

	@Override
	public Customer deleteCustomerByIdDao(int customerId) {
		return null;
	}

}
