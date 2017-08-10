package com.worldline.fpl.recruitment.dao.impl;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.worldline.fpl.recruitment.dao.AccountRepository;
import com.worldline.fpl.recruitment.entity.Account;
import com.worldline.fpl.recruitment.exception.ServiceException;
import com.worldline.fpl.recruitment.json.ErrorCode;

/**
 * Implementation of {@link AccountRepository}
 * 
 * @author A525125
 *
 */
@Repository
@Transactional
public class AccountRepositoryImpl implements AccountRepository,
		InitializingBean {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void afterPropertiesSet() throws Exception {

	}

	@Override
	public Page<Account> findAll(Pageable p) {

		List<Account> accounts = entityManager.createQuery("from Account")
				.getResultList();
		return new PageImpl<Account>(accounts);
	}

	@Override
	public Optional<Account> findById(Long accountId) {
		Query query = entityManager.createQuery("from Account WHERE id = :id")
				.setParameter("id", accountId);
		if (!query.getResultList().isEmpty())
			return Optional.of((Account) query.getResultList().get(0));
		throw new ServiceException(ErrorCode.NOT_FOUND_ACCOUNT,
				"Account doesn't exist");

	}

	@Override
	public boolean exists(Long accountId) {
		Query query = entityManager.createQuery("from Account WHERE id = :id")
				.setParameter("id", accountId);
		if (!query.getResultList().isEmpty())
			return true;
		return false;
	}
}
