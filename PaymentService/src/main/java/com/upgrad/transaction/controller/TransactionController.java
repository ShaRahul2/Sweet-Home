package com.upgrad.transaction.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.upgrad.transaction.exception.model.TransactionIdNotFoundException;
import com.upgrad.transaction.model.TransactionDetailsEntity;
import com.upgrad.transaction.service.TransactionService;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@AllArgsConstructor
public class TransactionController {

	private TransactionService transactionService; 

	@PostMapping(value = "/transaction",
			produces = {
					"application/json",
					"application/xml"
	},
			consumes = {
					"application/json",
					"application/xml"
	}
			)
	public void createTransaction(@RequestBody TransactionDetailsEntity transactionDetailsEntity) {
	
		 transactionService.saveTransaction(transactionDetailsEntity);
	}

	@PostMapping(value = "/booking/{txId}/payment",
			produces = {
					"application/json",
					"application/xml"
	},
			consumes = {
					"application/json",
					"application/xml"
	}
			)
	public TransactionDetailsEntity paymenTransactionInfo(@PathVariable("txId") Integer txId) {
		return transactionService.findByPaymentTransactionInfoById(txId);
	}
	
	@GetMapping(
			value = "/transaction/{id}",
			produces = {
					"application/json",
					"application/xml"
			}
			)
	public TransactionDetailsEntity transactionDetailsById(@PathVariable("id") Integer txId) throws TransactionIdNotFoundException {
		return transactionService.findByPaymentTransactionInfoById(txId);
	}
}
