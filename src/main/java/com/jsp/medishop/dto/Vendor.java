package com.jsp.medishop.dto;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.Data;

@Entity
@Data
public class Vendor {

	@Id
	private int id;
	private String name;
	@Column(unique = true,nullable = false)
	private String email;
	@Column(length = 16)
	private String password;
	private String address;
	@Column(unique = true,nullable = false)
	private long phone;
	@Column(unique = true,nullable = false,length = 12)
	private long adharnumber;
	
	@ManyToMany
	private List<Customer> customers;
	
}
