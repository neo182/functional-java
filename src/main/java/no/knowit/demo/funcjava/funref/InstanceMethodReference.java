package no.knowit.demo.funcjava.funref;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Supplier;

public class InstanceMethodReference {
    public int add(int a, int b){
        return a+b;
    }
    public static void main(String[] args) {
        InstanceMethodReference methodRef = new InstanceMethodReference();
        BiFunction<Integer, Integer, Integer> adder = methodRef::add;
        int result = adder.apply(10, 20);
        BiFunction<Integer, Integer, Integer> adder2 = (a, b) -> methodRef.add(a, b);
        System.out.println(result);

        // Using a method reference
        Supplier<List<String>> s =  ArrayList::new;
        List<String> l = s.get();



    }
}