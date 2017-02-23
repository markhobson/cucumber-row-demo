package demo;

import java.math.BigDecimal;

import org.hamcrest.Matcher;

import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasProperty;

public class AccountRow {
	
	private String name;
	
	private BigDecimal balance;
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public BigDecimal getBalance() {
		return balance;
	}
	
	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}
	
	public Account toModel() {
		return new Account(name, balance);
	}
	
	public Matcher<Account> toMatcher() {
		return allOf(
			hasProperty("name", equalTo(name)),
			hasProperty("balance", equalTo(balance))
		);
	}
}
