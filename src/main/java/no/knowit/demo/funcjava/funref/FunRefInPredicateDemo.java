package no.knowit.demo.funcjava.funref;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FunRefInPredicateDemo {
    class Person {
        String name;
        int age;
        boolean isAdult() {
            return this.age >= 18;
        }

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        @Override
        public String toString() {
            return name;
        }

        boolean beginsWithS() {
            return this.name.startsWith("s");
        }
    }

    public void demo() {
        List<Person> people = Arrays.asList(new Person("Ola", 23),new Person("Kai", 16));
        List<Person> adults = people.stream()
                .filter(Person::isAdult)
                .collect(Collectors.toList());
        adults.forEach(System.out::println);

        List<Person> peopleStaringWithLetterO = people.stream()
                .filter(Person::beginsWithS)
                .collect(Collectors.toList());
        peopleStaringWithLetterO.forEach(System.out::println);

        //this can not be replaced with function ref
        List<String> peopleStaringWithLetterK = people.stream()
                .map(person -> person.name)
                .filter(s -> s.startsWith(  "K")) //this line
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        new FunRefInPredicateDemo().demo();
    }
}
