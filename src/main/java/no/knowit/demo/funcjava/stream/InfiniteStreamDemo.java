package no.knowit.demo.funcjava.stream;

import java.util.UUID;
import java.util.stream.Stream;

public class InfiniteStreamDemo {
    public static void main(String[] args) {
        Stream<String> uuidStream = Stream.generate(() -> UUID.randomUUID().toString());
        // uncommenting the following line will result in an infinite stream that never terminates
        // uuidStream.forEach(System.out::println);
        System.out.println("Demo ended!");
    }
}
