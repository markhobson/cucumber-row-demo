package demo;

import java.math.BigDecimal;
import java.util.Optional;
import java.util.stream.Stream;

import org.hamcrest.Matcher;

import demo.Account.AccountType;

import static java.math.BigDecimal.ZERO;
import static java.util.stream.Collectors.toList;

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
			Optional.ofNullable(name).orElse("Unnamed"),
			Optional.ofNullable(type).orElse(CURRENT),
			Optional.ofNullable(balance).orElse(ZERO)
		);
	}
	
	public Matcher<Account> toMatcher() {
		return allOf(
			Stream.of(
				Optional.ofNullable(name).map(value -> hasProperty("name", equalTo(value))),
				Optional.ofNullable(type).map(value -> hasProperty("type", equalTo(value))),
				Optional.ofNullable(balance).map(value -> hasProperty("balance", equalTo(value)))
			)
			.filter(Optional::isPresent)
			.map(Optional::get)
			.collect(toList())
		);
	}
}
