package com.upgrad.transaction.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.upgrad.transaction.exception.model.TransactionIdNotFoundException;
import com.upgrad.transaction.model.TransactionDetailsEntity;
import com.upgrad.transaction.repository.TransactionRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class TransactionService {

	private TransactionRepository transactionRepository;
	
	public void saveTransaction(TransactionDetailsEntity transactionDetailsEntity) {
		transactionRepository.save(transactionDetailsEntity);
	}

	public TransactionDetailsEntity findByPaymentTransactionInfoById(Integer txId) {
		Optional<TransactionDetailsEntity> optional = transactionRepository.findById(txId);
		if(!optional.isPresent()) {
			throw new TransactionIdNotFoundException("Transaction Id not Found " + txId);
		}
		return optional.get();
	}
}
