package com.jsp.medishop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.medishop.dto.OrderEntitiy;

public interface OrderEntityRepository extends JpaRepository<OrderEntitiy, Long> {

	
}
