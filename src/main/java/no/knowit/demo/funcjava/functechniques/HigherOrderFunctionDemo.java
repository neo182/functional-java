package no.knowit.demo.funcjava.functechniques;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class HigherOrderFunctionDemo {

	public static void main(String[] args) {
		List<String> friends = Arrays.asList("Nils", "Bjørn","Ola");
		final Predicate<String> startsWithN = name -> name.startsWith("N");
		final Predicate<String> startsWithB = name -> name.startsWith("B");

		final long countFriendsStartN = friends.stream().filter(startsWithN).count();
		final long countFriendsStartB = friends.stream().filter(startsWithB).count();
		
		//can be don with
		final long countStartsWithN = friends.stream().filter(checkIfStartsWith("N")).count();
		final long countStartsWithB = friends.stream().filter(checkIfStartsWith("B")).count();
	}
	
	public static Predicate<String> checkIfStartsWith(final String letter) {
		return name -> name.startsWith(letter);
	}
	
	//even better, narrowing the scope
	final static Function<String, Predicate<String>> startsWithLetter =
		(String letter) -> {
		Predicate<String> checkStarts = (String name) -> name.startsWith(letter);
		return checkStarts;
	};
}
