package problem_01_and_02;

import javax.naming.OperationNotSupportedException;
import java.util.ArrayList;
import java.util.List;

public class Database {
    private List<Person> people;

     Database() {
        this.people = new ArrayList<>();
    }

    public List<Person> getPeople() {
        return people;
    }

    public void add(Person person) throws OperationNotSupportedException {
        if (person.getId() <= 0 || this.people.size() == 16 ||
                isAnotherUserWithThisId(person.getId())) {
            throw new OperationNotSupportedException();
        }
        this.people.add(person);
    }


    public void remove(Person person) throws OperationNotSupportedException {
        if (this.people.size() == 0 ) {
            throw new OperationNotSupportedException();
        }

        this.people.remove(person);
    }

    public Person findByUsername(String personName) throws OperationNotSupportedException {
        if (personName == null) {
            throw new OperationNotSupportedException();
        }

        for (Person person : people) {
            if (person.getName().equals(personName)) {
                return person;
            }
        }
        throw new OperationNotSupportedException();
    }

    public Person findById(Long id) throws OperationNotSupportedException {
        for (Person person : people) {
            if (person.getId().equals(id)) {
                return person;
            }
        }
        throw new OperationNotSupportedException();
    }

    private boolean isAnotherUserWithThisId(Long id) {
        for (Person person : people) {
            if (person.getId().equals(id)) {
                return true;
            }
        }
        return false;
    }
}
