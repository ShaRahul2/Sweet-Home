package com.upgrad.transaction.model;

import java.time.LocalDateTime;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.Getter;
import lombok.Setter;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@Getter @Setter
public class Auditable<T> {
	
	@CreatedBy
	protected T createdByT;
	
	@CreatedDate
	protected LocalDateTime createdDateTime;
	
	@LastModifiedBy
	protected T lastModifiedBy;
	
	@LastModifiedDate
	protected LocalDateTime lastModifieDateTime;
}
