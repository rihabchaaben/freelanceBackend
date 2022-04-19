package com.example.demo.exceptions;

public class SubcategoryNotFoundException extends RuntimeException {
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

public SubcategoryNotFoundException(String message) {
	super(message);
}
}