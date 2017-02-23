package demo;

import java.math.BigDecimal;

public class Account {
	
	private final String name;
	
	private final BigDecimal balance;
	
	public Account(String name, BigDecimal balance) {
		this.name = name;
		this.balance = balance;
	}
	
	public String getName() {
		return name;
	}
	
	public BigDecimal getBalance() {
		return balance;
	}
}
