package demo;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Bank {
	
	private final Set<Account> accounts;
	
	public Bank() {
		accounts = new HashSet<>();
	}
	
	public void addAccount(Account account) {
		accounts.add(account);
	}
	
	public void removeAllAccounts() {
		accounts.clear();
	}
	
	public Set<Account> getAccounts() {
		return Collections.unmodifiableSet(accounts);
	}
}
