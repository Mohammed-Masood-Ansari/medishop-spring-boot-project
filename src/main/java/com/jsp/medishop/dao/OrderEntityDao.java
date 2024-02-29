package com.jsp.medishop.dao;

import com.jsp.medishop.dto.OrderEntitiy;

public interface OrderEntityDao {

	public OrderEntitiy saveOrderEntitiyDao(OrderEntitiy entitiy);
	public OrderEntitiy getOrderEntitiyByIdDao(long orderId);
}
