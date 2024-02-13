package com.jsp.medishop.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.jsp.medishop.dao.impl.CustomerDaoImpl;
import com.jsp.medishop.dto.Customer;
import com.jsp.medishop.response.ResponseStructure;
import com.jsp.medishop.service.CustomerService;
import com.jsp.medishop.verification.EmailPasswordVerification;

/**
 * @author Mo Masood Ansari
 *
 */
@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerDaoImpl daoImpl;

	@Autowired
	private ResponseStructure<Customer> responseStructure;

	@Autowired
	private ResponseStructure<List<Customer>> responseStructure2;

	@Autowired
	private EmailPasswordVerification verification;

	/**
	 * 
	 */
	@Override
	public ResponseStructure<Customer> saveCustomerService(Customer customer) {
		String email = verification.verifyEmail(customer.getEmail());
		String password = verification.verifyPassword(customer.getPassword());
		
		if(email!=null) {
			if(password!=null) {
				Customer customer1=daoImpl.saveCustomerDao(customer);
				responseStructure.setStatusMsg("Data----Stored----");
				responseStructure.setStatusCode(HttpStatus.CREATED.value());
				responseStructure.setData(customer1);
			}else {
				responseStructure.setStatusMsg("please check your password it should include 8 to 16 characters with Alphabet, number, special character");
				responseStructure.setStatusCode(HttpStatus.NOT_ACCEPTABLE.value());
				responseStructure.setData(null);
			}
		}else {
			responseStructure.setStatusMsg("please check your Email it should include alphabet,numbers,@ and .");
			responseStructure.setStatusCode(HttpStatus.NOT_ACCEPTABLE.value());
			responseStructure.setData(null);
		}
		
		return responseStructure;
	}

	@Override
	public ResponseStructure<Customer> getCustomerByIdService(int customerId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseStructure<List<Customer>> getAllCustomerService() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseStructure<Customer> getCustomerByEmailService(String customerEmail) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseStructure<Customer> updateCustomerByEmailService(Customer customer) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseStructure<Customer> deleteCustomerByIdService(int customerId) {
		// TODO Auto-generated method stub
		return null;
	}

}
