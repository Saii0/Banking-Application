package in.sp.main.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.sp.main.entity.Account;
import in.sp.main.repository.AccountRepository;
@Service
public class AccountServiceImpl implements AccountService {
	
	@Autowired
	AccountRepository repo;

	@Override
	public Account createAccount(Account account) {
		Account account_saved = repo.save(account);
		return account_saved;
	}

	@Override
	public Account getAccountByAccountNum(Long accountNumber) {
		Optional<Account> account = repo.findById(accountNumber);
		if(account.isEmpty()) {
			throw new RuntimeException("Account is not present");
		}
		Account account_found = account.get();
		return account_found;
	}

	@Override
	public List<Account> getAllAccount() {
		List<Account> list=repo.findAll();
		return list;
	}

	@Override
	public Account depositMoney(Long accountNumber, Double amount) {
		Optional<Account> account = repo.findById(accountNumber);
		if(account.isEmpty()) {
			throw new RuntimeException("Account not found");
		}
		Account accountPresent = account.get();
		Double TotalBalance = accountPresent.getAccount_balance() + amount;
		accountPresent.setAccount_balance(TotalBalance);
		repo.save(accountPresent);
		return accountPresent;
	}

	@Override
	public Account withdrawMoney(Long accountNumber, Double amount) {
		Optional<Account> account = repo.findById(accountNumber);
		if(account.isEmpty()) {
			throw new RuntimeException("Account not found");
		}
		Account accountPresent = account.get();
		Double TotalBalance = accountPresent.getAccount_balance() - amount;
		accountPresent.setAccount_balance(TotalBalance);
		repo.save(accountPresent);
		return accountPresent;
		
	}

	@Override
	public void closeAccount(Long accountNumber) {
		getAccountByAccountNum(accountNumber);
		repo.deleteById(accountNumber);
		
		
	}

}
