package problem_06_StrategyPattern;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int countOfNames = Integer.parseInt(br.readLine());
        TreeSet<Person> firstSet = new TreeSet<>(new PersonComparatorOne());
        TreeSet<Person> secondSet = new TreeSet<>(new PersonComparatorTwo());
        while (countOfNames-- > 0) {
            String[] tokens = br.readLine().split("\\s+");
            Person currentPerson = new Person(tokens[0], Integer.valueOf(tokens[1]));

            firstSet.add(currentPerson);
            secondSet.add(currentPerson);
        }

        firstSet.forEach(System.out::println);
        secondSet.forEach(System.out::println);
    }
}
