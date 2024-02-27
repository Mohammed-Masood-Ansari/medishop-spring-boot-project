package com.jsp.medishop.dao.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.medishop.dao.VendorDao;
import com.jsp.medishop.dto.Admin;
import com.jsp.medishop.dto.Vendor;
import com.jsp.medishop.repository.AdminRepository;
import com.jsp.medishop.repository.VendorRepository;

import jakarta.servlet.http.HttpSession;


/**
 * @author Mo Masood Ansari
 *
 */
@Repository
class VendorDaoImpl implements VendorDao {

	@Autowired
	private VendorRepository vendorRepository;

	@Autowired
	private HttpSession httpSession;
	
	@Autowired
	private AdminRepository adminRepository;
	
	@Override
	public Vendor saveVendorDao(Vendor vendor) {
		return vendorRepository.save(vendor);
	}

	@Override
	public Vendor getVendorByIdDao(int id) {
		Optional<Vendor> optional=vendorRepository.findById(id);
		if(optional.isPresent()) {
			return optional.get();
		}else {
			return null;
		}
	}

	@Override
	public Vendor getVendorByEmailDao(String email) {
		return vendorRepository.findByEmail(email);
	}

	@Override
	public List<Vendor> getVendorsDao() {
		return vendorRepository.findAll();
	}

	@Override
	public Vendor updateVendorByEmailDao(Vendor vendor) {
		Vendor vendor2 = getVendorByEmailDao(vendor.getEmail());
		if (vendor2 != null) {
			return vendorRepository.save(vendor);
		}
		return null;
	}

	@Override
	public Vendor deleteVendorByEmailDao(String email) {
		Vendor vendor = getVendorByEmailDao(email);
		if (vendor != null) {
			vendorRepository.delete(vendor);
			return null;
		}
		return vendor;
	}

	@Override
	public Vendor vendorVerifyByIdDao(int id) {
		
		String adminEmail = (String) httpSession.getAttribute("adminEmail");
		
		Vendor vendor=getVendorByIdDao(id);
		
		Admin admin=adminRepository.findByEmail(adminEmail);
		
		if(vendor!=null) {
			vendor.setVendorStatus("active");
			vendor.setAdmin(admin);
			return vendorRepository.save(vendor);
		}
		return null;
	}
}
