package com.jsp.medishop.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.jsp.medishop.dao.VendorDao;
import com.jsp.medishop.dto.Vendor;
import com.jsp.medishop.response.ResponseStructure;
import com.jsp.medishop.service.VendorService;
import com.jsp.medishop.verification.EmailPasswordVerification;

import jakarta.servlet.http.HttpSession;


/**
 * @author Mo Masood Ansari
 *
 */
@Service
public class VendorServiceImpl implements VendorService {

	@Autowired
	private HttpSession httpSession;
	@Autowired
	private VendorDao dao;
	@Autowired
	private EmailPasswordVerification verification;
	@Autowired
	private ResponseStructure<Vendor> structure;
	@Autowired
	private ResponseStructure<List<Vendor>> structure2;

	@Override
	public ResponseStructure<Vendor> saveVendorService(Vendor vendor) {
		String email = verification.verifyEmail(vendor.getEmail());
		String password = verification.verifyPassword(vendor.getPassword());
		if (email != null) {
			if (password != null) {
				dao.saveVendorDao(vendor);
				structure.setData(vendor);
				structure.setMsg("Data Inserted!!!");
				structure.setStatus(HttpStatus.CREATED.value());
			} else {
				structure.setData(vendor);
				structure.setMsg("Please create a vaild password!!!");
				structure.setStatus(HttpStatus.NOT_ACCEPTABLE.value());
			}
		} else {
			structure.setData(vendor);
			structure.setMsg("Please enter a vaild email!!!");
			structure.setStatus(HttpStatus.NOT_ACCEPTABLE.value());
		}
		return structure;

	}

	@Override
	public ResponseStructure<Vendor> getVendorByIdService(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseStructure<Vendor> getVendorByEmailService(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Vendor> getVendorsService() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseStructure<List<Vendor>> updateVendorByEmailService(Vendor vendor) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseStructure<Vendor> deleteVendorByEmailService(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseStructure<Vendor> loginVendorByEmailAndPasswordService(String email, String password) {
		
		
		Vendor vendor=dao.getVendorByEmailDao(email);
		
		if(vendor!=null) {
			
			if(vendor.getPassword().equals(password)) {
				httpSession.setAttribute("vendorEmail", email);
				structure.setStatus(HttpStatus.OK.value());
				structure.setMsg("vendor-----login----successfully");
				vendor.setPassword("***********");
				structure.setData(vendor);
			}else {
				
			}
		}else {
			
		}
		
		return structure;
	}

}
