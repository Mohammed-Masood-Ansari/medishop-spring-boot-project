package com.jsp.medishop.service;

import com.jsp.medishop.dto.OrderEntitiy;
import com.jsp.medishop.response.ResponseStructure;

public interface OrderEntityService {

	public ResponseStructure<OrderEntitiy> saveOrderEntitiyService(OrderEntitiy entitiy,int medicineId);

	public ResponseStructure<OrderEntitiy> getOrderEntitiyByIdService(int orderId);
}
