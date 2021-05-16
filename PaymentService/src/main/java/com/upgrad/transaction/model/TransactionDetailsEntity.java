package com.upgrad.transaction.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.hibernate.annotations.NaturalId;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity(name = "transaction")
@AllArgsConstructor
@NoArgsConstructor 
@Getter @Setter
@ToString(callSuper = false)
public class TransactionDetailsEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer transactionId;
	
	private String paymentMode;
	
	@NaturalId(mutable = false)
	@NotBlank(message = "Booking Id Mode May Not Be Blank")
	private Long bookingId;
	
	@NaturalId(mutable = false)
	private String upiId;
	
	@Column(nullable = true, updatable = false, unique = true)
	@Size(max = 16, message = "Card Number Should Be 16 Digits")
	private String  cardNumber;

	public TransactionDetailsEntity(String paymentMode, Long bookingId, String upiId, String cardNumber) {
		this.paymentMode = paymentMode;
		this.bookingId = bookingId;
		this.upiId = upiId;
		this.cardNumber = cardNumber;
	}
	
	@JsonProperty("id")
	public Integer getTransactionId(Integer transactionId) {
		return transactionId;
	}
}
