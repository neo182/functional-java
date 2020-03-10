package no.knowit.demo.funcjava.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class HigherOrderFunction {

	// Reusable Predicate taking starting letter as parameter
	public static Predicate<String> checkIfStartsWith(final String letter) {
		return name -> name.startsWith(letter);
	}

	public static void main(String[] args) {
		List<String> friends = Arrays.asList("Nil", "Ola", "Bill");

		// Before : One predicate per one case,
		// Demo : introduce one statement elegence in lambda
		final Predicate<String> startsWithN = (String name) -> {
			return name.startsWith("N");
		};
		final Predicate<String> startsWithB = name -> name.startsWith("B");
		final long countFriendsStartN_Rep_lambda = friends.stream().filter(startsWithN).count();
		final long countFriendsStartB_Rep_lambda = friends.stream().filter(startsWithB).count();

		final long countFriendsStartN = friends.stream().filter(checkIfStartsWith("N")).count();
		final long countFriendsStartB = friends.stream().filter(checkIfStartsWith("B")).count();

		// Demo :: Narrowing scope and refactor to demo higher-order function
		final Function<String, Predicate<String>> startsWithLetterHigherOrder = (String letter) -> {
			Predicate<String> checkStarts = (String name) -> name.startsWith(letter);
			return checkStarts;
		};

		final long countFriendsStartN_Narrow = friends.stream().filter(startsWithLetterHigherOrder.apply("N")).count();

		Function<List<Integer>, Integer> maxInListFuncRef = Collections::max;
		int maxItem = maxInListFuncRef.apply(Arrays.asList(1, 2, 3, 4));
		System.out.println(maxItem);

		List<String> words = new ArrayList<>();
		Consumer<String> collectionUpdater = words::add;
		collectionUpdater.accept("first");
		collectionUpdater.accept("second");
		words.stream().forEach(System.out::println);

	}

}
