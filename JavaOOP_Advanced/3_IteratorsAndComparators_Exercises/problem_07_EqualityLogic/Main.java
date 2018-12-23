package problem_07_EqualityLogic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int countOfPersons = Integer.parseInt(br.readLine());

        TreeSet<Person> treeSet = new TreeSet<>();
        HashSet<Person> hashSet = new HashSet<>();

        while (countOfPersons-- > 0) {
            String[] tokens = br.readLine().split("\\s+");

            Person currentPerson = new Person(tokens[0],Integer.valueOf(tokens[1]));

            treeSet.add(currentPerson);
            hashSet.add(currentPerson);
        }

        System.out.println(treeSet.size());
        System.out.println(hashSet.size());
    }
}
