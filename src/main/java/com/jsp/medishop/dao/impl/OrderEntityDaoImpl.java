package com.jsp.medishop.dao.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.medishop.dao.OrderEntityDao;
import com.jsp.medishop.dto.OrderEntitiy;
import com.jsp.medishop.repository.OrderEntityRepository;

@Repository
public class OrderEntityDaoImpl implements OrderEntityDao {
	
	@Autowired
	private OrderEntityRepository entityRepository;

	@Override
	public OrderEntitiy saveOrderEntitiyDao(OrderEntitiy entitiy) {
		return entityRepository.save(entitiy);
	}

	@Override
	public OrderEntitiy getOrderEntitiyByIdDao(long orderId) {
		Optional<OrderEntitiy> optional = entityRepository.findById(orderId);
		return (optional.isPresent())?optional.get():null;
	}

}
