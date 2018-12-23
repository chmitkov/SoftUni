package problem_06_StrategyPattern;

import java.util.Comparator;

public class PersonComparatorTwo implements Comparator<Person> {
    @Override
    public int compare(Person firstPerson, Person secondPerson) {
        return firstPerson.getAge() - secondPerson.getAge();
    }
}
