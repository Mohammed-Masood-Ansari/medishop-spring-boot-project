package com.jsp.medishop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.medishop.dto.Admin;
import com.jsp.medishop.response.ResponseStructure;
import com.jsp.medishop.service.AdminService;

@RestController
public class AdminController {

	@Autowired
	private AdminService adminService;
	
	@GetMapping("/loginAdmin")
	public ResponseStructure<Admin> loginAdminByEmailAndPasswordController(@RequestBody Admin admin) {
		return adminService.loginAdminByEmailAndPasswordService(admin);
	}
	
	@RequestMapping("/logout")
	public ResponseEntity<String> logoutAdmincontroller() {
		return adminService.logoutAdminService();
	}
}
