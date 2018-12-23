package problem_06_StrategyPattern;

import java.util.Comparator;

public class PersonComparatorOne implements Comparator<Person> {
    @Override
    public int compare(Person firstPerson, Person secondPerson) {
        if (firstPerson.getName().length() - secondPerson.getName().length() == 0) {
            return firstPerson.getName().toLowerCase().charAt(0) -
                    secondPerson.getName().toLowerCase().charAt(0);
        }
        return firstPerson.getName().length() - secondPerson.getName().length();
    }
}
