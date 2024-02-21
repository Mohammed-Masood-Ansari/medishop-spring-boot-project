package com.jsp.medishop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.medishop.dto.Medicine;
import com.jsp.medishop.response.ResponseStructure;
import com.jsp.medishop.service.MedicineService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping(value = "/medicine")
public class MedicineController {

	@Autowired
	private MedicineService medicineService;
	
	@PostMapping(value = "/saveMedicine")
	public ResponseStructure<Medicine> saveMedicineController(@RequestBody Medicine medicine) {
		return medicineService.saveMedicineService(medicine);
	}
}
