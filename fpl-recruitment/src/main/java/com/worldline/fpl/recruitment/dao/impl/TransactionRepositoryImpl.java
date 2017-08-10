package com.worldline.fpl.recruitment.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import com.worldline.fpl.recruitment.dao.TransactionRepository;
import com.worldline.fpl.recruitment.entity.Transaction;

/**
 * Implementation of {@link TransactionRepository}
 * 
 * @author A525125
 *
 */
@Repository
public class TransactionRepositoryImpl implements TransactionRepository,
		InitializingBean {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void afterPropertiesSet() throws Exception {

	}

	@Override
	public Transaction findById(Long transactionId) {
		return (Transaction) entityManager
				.createQuery("from Transaction WHERE id = :id")
				.setParameter("id", transactionId).getSingleResult();

	}

	@Override
	public Page<Transaction> getTransactionsByAccount(Long accountId, Pageable p) {
		return new PageImpl<Transaction>(entityManager
				.createQuery("from Transaction t WHERE t.account.id = :id")
				.setParameter("id", accountId).getResultList());

	}

}
