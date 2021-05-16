package com.upgrad.transaction.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.upgrad.transaction.model.TransactionDetailsEntity;

@Repository
public interface TransactionRepository extends JpaRepository<TransactionDetailsEntity, Serializable> {
	
}
