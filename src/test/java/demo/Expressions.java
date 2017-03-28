package demo;

import java.time.LocalDate;
import java.util.Optional;

import org.hamcrest.Matcher;

import static org.hamcrest.CoreMatchers.nullValue;
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
	
	public static String evaluateNullValue(String expression) {
		return "[null]".equals(expression) ? null : expression;
	}
	
	public static Optional<Matcher<?>> evaluateMatcher(String expression) {
		Matcher<?> matcher = null;

		if ("[null]".equals(expression)) {
			matcher = nullValue();
		}
		else if ("[past]".equals(expression)) {
			matcher = lessThan(LocalDate.now());
		}

		return Optional.ofNullable(matcher);
	}
}
