package no.knowit.demo.funcjava.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class LazyEvaluationDemo {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        // These operations do not perform any execution -- they just build the pipeline
        Stream<Integer> stream = numbers.stream().map(n -> n / 0).filter(n -> n % 2 == 0);

        //Removing comment on following code adds terminal operation to the stream pipeline, then the stream is executed
        //and an ArithmeticException is thrown
        //stream.forEach(System.out::println);

        System.out.println("Demo complited");
    }
}