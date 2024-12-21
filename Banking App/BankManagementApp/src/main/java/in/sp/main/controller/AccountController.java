package in.sp.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.sp.main.entity.Account;
import in.sp.main.service.AccountService;

@RestController
@RequestMapping("/account")
public class AccountController {
	@Autowired
	AccountService service;
	
	@PostMapping("/create")
	public ResponseEntity<Account> createAccount(@RequestBody Account account) {
		Account createAccount = service.createAccount(account);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(createAccount);
		
	}
	
	@GetMapping("/{accountNumber}")
	public Account getAccountByAccountNum(@PathVariable Long accountNumber) {
		Account account = service.getAccountByAccountNum(accountNumber);
		return account;
	}
	
	@GetMapping("/getallaccounts")
	public List<Account> getAllAccount(){
		List<Account> allAccount = service.getAllAccount();		
		return allAccount;
	}

}
