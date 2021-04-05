package repo;

import bank.Account;

public interface AccountDAO {
	
	Account findById(int id);
	boolean updateAccount(Account account);

}