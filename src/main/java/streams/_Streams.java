package streams;

import org.w3c.dom.ls.LSOutput;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class _Streams {
    public static void main(String[] args) {

        List<Person> people = List.of(
                new Person("Johnny", Gender.MALE),
                new Person("Maria", Gender.FEMALE),
                new Person("Aisha", Gender.FEMALE),
                new Person("Alex", Gender.MALE),
                new Person("Alice", Gender.FEMALE)
        );

//        Filter
        List<Person> females = people.stream()
                .filter(person -> person.getGender().equals(Gender.FEMALE))
                .collect(Collectors.toList());

//        Sort
        List<Person> sorted = people.stream()
                .sorted(Comparator.comparing(Person::getGender))
                .collect(Collectors.toList());

        List<Person> reverseSorted = people.stream()
                .sorted(Comparator.comparing(Person::getGender).reversed())
                .collect(Collectors.toList());

        List<Person> sortByNameAndThenGender = people.stream()
                .sorted(Comparator.comparing(Person::getName).thenComparing(Person::getGender))
                .collect(Collectors.toList());

//        All Match
        boolean allMatch = people.stream()
                .allMatch(person -> person.getGender().equals(Gender.FEMALE));

//        Any Match
        boolean anyMatch = people.stream()
                .anyMatch(person -> person.getGender().equals(Gender.FEMALE));

//        None Match
        boolean noneMatch = people.stream()
                .noneMatch(person -> person.getGender().equals(Gender.FEMALE));

//        Max
        people.stream()
                .max(Comparator.comparing(person -> person.getName().length()))
                .ifPresent(System.out::println);

//        Min
        people.stream()
                .min(Comparator.comparing(person -> person.getName().length()))
                .ifPresent(System.out::println);

//        Group
        Map<Gender, List<Person>> groupByGender = people.stream()
                .collect(Collectors.groupingBy(Person::getGender));

        groupByGender.forEach((gender, person) -> System.out.println(gender + " " + person));
    }

    static class Person {
        private final String name;
        private final Gender gender;

        public Person(String name, Gender gender) {
            this.name = name;
            this.gender = gender;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", gender=" + gender +
                    '}';
        }

        public String getName() {
            return name;
        }

        public Gender getGender() {
            return gender;
        }
    }

    enum Gender {
        MALE, FEMALE
    }
}
