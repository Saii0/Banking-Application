package in.sp.main.service;

import java.util.List;

import in.sp.main.entity.Account;

public interface AccountService {
	public Account createAccount(Account account);
	public Account getAccountByAccountNum(Long accountNumber);
	public List<Account> getAllAccount();
	public Account depositMoney(Long accountNumber, Double amount);
	public Account withdrawMoney(Long accountNumber, Double amount);
	public void closeAccount(Long accountNumber);

}
