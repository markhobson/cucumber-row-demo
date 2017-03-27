package demo;

import java.time.LocalDate;
import java.util.Optional;

import org.hamcrest.Matcher;

import static org.hamcrest.number.OrderingComparison.lessThan;

public final class Expressions {
	
	private Expressions() {
		throw new AssertionError();
	}
	
	public static String evaluateValue(String expression) {
		return Optional.ofNullable(expression)
			.map(value -> value.replace("[today]", LocalDate.now().toString()))
			.orElse(null);
	}
	
	public static Optional<Matcher<?>> evaluateMatcher(String expression) {
		return Optional.ofNullable(expression)
			.map(value -> "[past]".equals(value) ? lessThan(LocalDate.now()) : null);
	}
}
