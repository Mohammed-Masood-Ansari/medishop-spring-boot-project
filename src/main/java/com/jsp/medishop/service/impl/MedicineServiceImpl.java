package com.jsp.medishop.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.jsp.medishop.dao.MedicineDao;
import com.jsp.medishop.dao.VendorDao;
import com.jsp.medishop.dto.Medicine;
import com.jsp.medishop.dto.Vendor;
import com.jsp.medishop.response.ResponseStructure;
import com.jsp.medishop.service.MedicineService;
import com.jsp.medishop.service.VendorService;

import jakarta.servlet.http.HttpSession;

@Service
public class MedicineServiceImpl implements MedicineService{

	
	@Autowired
	private VendorDao vendorDao;
	
	@Autowired
	private HttpSession httpSession;
	
	@Autowired
	private MedicineDao dao;
	
	@Autowired
	private ResponseStructure<Medicine> responseStructure;
	
	@Autowired
	private ResponseStructure<List<Medicine>> responseStructure2;
	
	@Override
	public ResponseStructure<Medicine> saveMedicineService(Medicine medicine) {
		
		String email =(String) httpSession.getAttribute("vendorEmail");
		
		if(email!=null) {
			 Vendor vendor=vendorDao.getVendorByEmailDao(email);
			 System.out.println(vendor.getEmail());
			 medicine.setVendors(new ArrayList<Vendor>(Arrays.asList(vendor)));
			 Medicine medicine2=dao.saveMedicineDao(medicine);
			 if(medicine2!=null) {
				 responseStructure.setStatus(HttpStatus.ACCEPTED.value());
				 responseStructure.setMsg("medicine addedd");
				 responseStructure.setData(medicine2);
			 }else {
				 responseStructure.setStatus(HttpStatus.NOT_ACCEPTABLE.value());
				 responseStructure.setMsg("Data is not stored check your code");
				 responseStructure.setData(null);
			 }
		}else {
			 responseStructure.setStatus(HttpStatus.NOT_ACCEPTABLE.value());
			 responseStructure.setMsg("please login with vendor and then add medicine....");
			 responseStructure.setData(null);
		}
		 return responseStructure;
	}

	@Override
	public ResponseStructure<List<Medicine>> getAllMedicineService() {
		     List<Medicine> medicines=dao.getAllMedicineDao();
		     if(!medicines.isEmpty()) {
				 responseStructure2.setStatus(HttpStatus.OK.value());
				 responseStructure2.setMsg("Data----Found----");
				 responseStructure2.setData(medicines);
			 }else {
				 responseStructure2.setStatus(HttpStatus.NOT_FOUND.value());
				 responseStructure2.setMsg("Data is not found might be table is empty or check your code");
				 responseStructure2.setData(medicines);
			 }
			 return responseStructure2;
	}

}
