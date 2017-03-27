package demo;

import java.time.LocalDate;
import java.util.Optional;

public final class Expressions {
	
	private Expressions() {
		throw new AssertionError();
	}
	
	public static String evaluateValue(String expression) {
		return Optional.ofNullable(expression)
			.map(value -> value.replace("[today]", LocalDate.now().toString()))
			.orElse(null);
	}
}
