package com.jsp.medishop.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.jsp.medishop.dao.MedicineDao;
import com.jsp.medishop.dto.Medicine;
import com.jsp.medishop.repository.MedicineRepository;

public class MedicineDaoImpl implements MedicineDao {

	@Autowired
	private MedicineRepository medicineRepository;
	
	@Override
	public Medicine saveMedicineDao(Medicine medicine) {
		return medicineRepository.save(medicine);
	}

	@Override
	public List<Medicine> getAllMedicineDao() {
		return medicineRepository.findAll();
	}

}
