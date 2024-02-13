package com.jsp.medishop.response;

import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class ResponseStructure<T> {
	private int statusCode;
	private String statusMsg;
	private T data;
}
