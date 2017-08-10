package com.worldline.fpl.recruitment.controller.impl;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.worldline.fpl.recruitment.controller.TransactionController;
import com.worldline.fpl.recruitment.exception.ServiceException;
import com.worldline.fpl.recruitment.json.ErrorCode;
import com.worldline.fpl.recruitment.json.TransactionResponse;
import com.worldline.fpl.recruitment.service.AccountService;
import com.worldline.fpl.recruitment.service.TransactionService;

/**
 * Implementation of {@link TransactionController}
 * 
 * @author A525125
 *
 */
@Slf4j
@RestController
public class TransactionControllerImpl implements TransactionController {

	private TransactionService transactionService;
	private AccountService accountService;

	@Autowired
	public TransactionControllerImpl(TransactionService transactionService,
			AccountService accountService) {
		this.transactionService = transactionService;
		this.accountService = accountService;
	}

	@Override
	public ResponseEntity<Page<TransactionResponse>> getTransactionsByAccount(
			@PathVariable("accountId") Long accountId,
			@PageableDefault Pageable p) {
		if (accountService.isAccountExist(accountId)) {
			Page<TransactionResponse> page = transactionService
					.getTransactionsByAccount(accountId, p);
			if (null == page || page.getTotalElements() == 0) {
				log.debug("Cannot find transaction for account {}", accountId);
				return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
			}
			return ResponseEntity.status(HttpStatus.OK).body(page);
		}
		log.debug("Cannot find account {}", accountId);
		throw new ServiceException(ErrorCode.NOT_FOUND_ACCOUNT,
				"Account doesn't exist");
	}
}
