package com.worldline.fpl.recrutment;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.worldline.fpl.recruitment.dao.AccountRepository;
import com.worldline.fpl.recruitment.dao.TransactionRepository;
import com.worldline.fpl.recruitment.entity.Account;

@Service
public class DataLoader {

	   private TransactionRepository teamRepository;
	    private AccountRepository gameRepository;

	    @Autowired
	    public DataLoader(AccountRepository gameRepository,
	    		TransactionRepository teamRepository) {
	        this.gameRepository = gameRepository;
	        this.teamRepository = teamRepository;
}

@PostConstruct
private void loadData(){
	ArrayList<Account> accounts = new ArrayList<>();

	{
		Account account = new Account();
//		account.setId("1");
		account.setCreationDate(new Date());
		account.setActive(true);
		account.setType("SAVING");
		account.setNumber("01000251215");
		account.setBalance(BigDecimal.valueOf(4210.42));
		accounts.add(account);
	}
	{
		Account account = new Account();
//		account.setId("2");
		account.setCreationDate(new Date());
		account.setActive(false);
		account.setType("CURRENT");
		account.setNumber("01000251216");
		account.setBalance(BigDecimal.valueOf(25.12));
		accounts.add(account);
	}
	
	
	}
}