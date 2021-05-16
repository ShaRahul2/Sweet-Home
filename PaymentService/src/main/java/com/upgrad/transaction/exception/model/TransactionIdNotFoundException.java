package com.upgrad.transaction.exception.model;

public class TransactionIdNotFoundException extends RuntimeException {

	private static final long serialVersionUID = -3540844636197295671L;
	
	public TransactionIdNotFoundException(String message) {
		super(message);
	}

}
