package no.knowit.demo.funcjava.stream;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class SimpleReducerDemo {
    public static void main(String[] args) {
        int factorialSimple = IntStream.rangeClosed(1, 5)
                .reduce((a, b) -> a * b).orElse(-1);
        System.out.println(factorialSimple);


        int factorialWithInitValue = IntStream.rangeClosed(1, 5)
                .reduce(1,  (a, b) -> a * b);

        System.out.println(factorialWithInitValue);

        //Versatile Reducer
        // This version uses combination of map() and reduce() operations.
        // first param : init value
        // second param:  map stream element type String to Integer and does accumulating
        // third param :  needed in parallel streams to combine the various split results together at the end
        int factorialWithVersatileReducer = Stream.of("1", "2", "3", "4", "5")
                .parallel()
                .reduce(1,
                        (num, s) ->  num * Integer.parseInt(s),
                        (num1, num2) -> num1 * num2);
        System.out.println(factorialWithVersatileReducer);
    }
}
