package no.knowit.demo.funcjava.functechniques;

import java.util.function.BiFunction;
import java.util.function.Function;

public class ClosureWithCurryDemo {
    public static void main(String[] args) {
        BiFunction<Integer, Integer, Integer> simpleAdder = (u, v) -> u + v;
        int sumSimple = simpleAdder.apply(2, 3);

        // Curried Function
        Function<Integer, Function<Integer, Integer>> curryAdder = u -> (v -> u + v);
        int sumCurry = curryAdder.apply(2).apply(3);

        Function<Integer, Function<Integer, Integer>> curryAdderWithClosure = u -> {
            return (v) -> {
                return (u + v);
            };
        };
        int sumCurryWithClosure = curryAdder.apply(2).apply(3);
        System.out.println(sumCurryWithClosure);
    }
}
