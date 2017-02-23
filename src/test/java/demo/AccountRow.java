package demo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.hamcrest.Matcher;

import demo.Account.AccountType;

import static java.math.BigDecimal.ZERO;

import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasProperty;

import static demo.Account.AccountType.CURRENT;

public class AccountRow {
	
	private String name;
	
	private AccountType type;
	
	private BigDecimal balance;
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public AccountType getType() {
		return type;
	}
	
	public void setType(AccountType type) {
		this.type = type;
	}
	
	public BigDecimal getBalance() {
		return balance;
	}
	
	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}
	
	public Account toModel() {
		return new Account(
			name,
			Optional.ofNullable(type).orElse(CURRENT),
			Optional.ofNullable(balance).orElse(ZERO)
		);
	}
	
	public Matcher<Account> toMatcher() {
		List<Matcher<? super Account>> matchers = new ArrayList<>();
		
		if (name != null) {
			matchers.add(hasProperty("name", equalTo(name)));
		}
		
		if (type != null) {
			matchers.add(hasProperty("type", equalTo(type)));
		}
		
		if (balance != null) {
			matchers.add(hasProperty("balance", equalTo(balance)));
		}
		
		return allOf(matchers);
	}
}
