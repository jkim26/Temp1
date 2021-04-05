package service;

import bank.Account;
import repo.AccountDAO;
import repo.AccountDAOImpl;

public class AccountService {
	
	AccountDAO aDao = new AccountDAOImpl();
	
	public Account getAccountById(int id) {
		return aDao.findById(id);
	}
	
	public boolean depositIntoAccount(double amount, Account acc) {
		if(amount<1) {
			return false;
		}
		
		acc.setBalance(amount+acc.getBalance());
		if(aDao.updateAccount(acc)) {
			return true;
		}
		return false;
	}

}