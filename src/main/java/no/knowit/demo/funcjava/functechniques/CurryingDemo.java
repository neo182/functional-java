package no.knowit.demo.funcjava.functechniques;

import java.util.function.BiFunction;
import java.util.function.Function;

public class CurryingDemo {
    public static void main(String[] args) {
        BiFunction<Integer, Integer, Integer> simpleAdder = (u, v) -> u + v;
        System.out.println("Add 2, 3 using simple adder :" + simpleAdder.apply(2,3));

        // Curried version
        Function<Integer, Function<Integer, Integer>>
                curryAdder = u -> (v -> u + v);
        System.out.println("Add 2, 3 using curried version :" + curryAdder.apply(2).apply(3));
    }
}
