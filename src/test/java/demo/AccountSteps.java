package demo;

import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java8.En;

public class AccountSteps implements En {
	
	public AccountSteps() {
		Given("^the system has no accounts$", () -> {
			throw new PendingException();
		});
		
		When("^the user adds the following accounts$", (DataTable accounts) -> {
			throw new PendingException();
		});
		
		Then("^the system has the following accounts$", (DataTable accounts) -> {
			throw new PendingException();
		});
	}
}
