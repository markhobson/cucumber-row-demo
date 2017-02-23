package demo;

import java.math.BigDecimal;

import static java.util.Objects.requireNonNull;

public class Account {
	
	public enum AccountType {
		CURRENT,
		SAVINGS;
	}
	
	private final String name;
	
	private final AccountType type;
	
	private final BigDecimal balance;
	
	public Account(String name, AccountType type, BigDecimal balance) {
		this.name = requireNonNull(name);
		this.type = requireNonNull(type);
		this.balance = requireNonNull(balance);
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
	
	@Override
	public String toString() {
		return String.format("%s[name=%s, type=%s, balance=%s]", getClass().getName(), name, type, balance);
	}
}
