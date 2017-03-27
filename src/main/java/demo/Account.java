package demo;

import java.math.BigDecimal;
import java.time.LocalDate;

import static java.util.Objects.requireNonNull;

public class Account {
	
	public enum AccountType {
		CURRENT,
		SAVINGS;
	}
	
	private final String name;
	
	private final AccountType type;
	
	private final BigDecimal balance;
	
	private final LocalDate opened;
	
	public Account(String name, AccountType type, BigDecimal balance, LocalDate opened) {
		this.name = requireNonNull(name);
		this.type = requireNonNull(type);
		this.balance = requireNonNull(balance);
		this.opened = requireNonNull(opened);
	}
	
	public String getName() {
		return name;
	}
	
	public AccountType getType() {
		return type;
	}
	
	public BigDecimal getBalance() {
		return balance;
	}
	
	public LocalDate getOpened() {
		return opened;
	}
	
	@Override
	public String toString() {
		return String.format("%s[name=%s, type=%s, balance=%s, opened=%s]", getClass().getName(), name, type, balance,
			opened);
	}
}
