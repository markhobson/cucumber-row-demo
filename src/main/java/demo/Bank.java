package demo;

import java.time.Clock;
import java.time.LocalDate;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Bank {
	
	private final Clock clock;
	
	private final Set<Account> accounts;
	
	public Bank(Clock clock) {
		this.clock = clock;
		accounts = new HashSet<>();
	}
	
	public void addAccount(Account account) {
		accounts.add(new Account(account.getName(), account.getType(), account.getBalance(), LocalDate.now(clock)));
	}
	
	public void removeAllAccounts() {
		accounts.clear();
	}
	
	public Set<Account> getAccounts() {
		return Collections.unmodifiableSet(accounts);
	}
}
