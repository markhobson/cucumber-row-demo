package demo;

import cucumber.api.DataTable;
import cucumber.api.java8.En;

import static java.util.stream.Collectors.toList;

import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.junit.Assert.assertThat;

public class AccountSteps implements En {
	
	private final Bank bank;
	
	public AccountSteps() {
		bank = new Bank();
		
		Given("^the system has no accounts$", bank::removeAllAccounts);
		
		When("^the user adds the following accounts$", (DataTable accounts) -> {
			accounts.asList(AccountRow.class)
				.stream()
				.map(AccountRow::toModel)
				.forEach(bank::addAccount);
		});
		
		Then("^the system has the following accounts$", (DataTable accounts) -> {
			assertThat(bank.getAccounts(), containsInAnyOrder(accounts.asList(AccountRow.class)
				.stream()
				.map(AccountRow::toMatcher)
				.collect(toList())
			));
		});
	}
}
