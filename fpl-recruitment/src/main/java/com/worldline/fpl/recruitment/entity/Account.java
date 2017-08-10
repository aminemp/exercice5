package com.worldline.fpl.recruitment.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

import lombok.Data;

/**
 * Account entity
 * 
 * @author A525125
 *
 */
@Data
@Entity
public class Account implements Serializable {

	private static final long serialVersionUID = -3548441891975414771L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String number;

	private String type;

	private BigDecimal balance;

	private Date creationDate;

	private boolean isActive;
	
	@OneToMany(mappedBy="account",fetch=FetchType.LAZY)
	private Set<Transaction> transactions;
}
