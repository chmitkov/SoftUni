package problem_07_EqualityLogic;


import java.util.stream.Stream;

public class Person implements Comparable<Person> {

    private String name;
    private int age;

    public Person(String name, int age) {
        this.setName(name);
        this.setAge(age);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }


    @Override
    public int compareTo(Person otherPerson) {
        if (this.getName().compareTo(otherPerson.getName()) == 0) {
            return this.getAge() - otherPerson.getAge();
        }
        return this.getName().compareTo(otherPerson.getName());
    }

    @Override
    public boolean equals(Object obj) {
        Person otherPerson = (Person) obj;
        return this.getName().equals(otherPerson.getName()) &&
                this.getAge() == otherPerson.getAge();
    }

    @Override
    public int hashCode() {
        int hashCode = this.getName().length() * 1000;

        for (char c : this.getName().toCharArray()) {
            hashCode += c;
        }

        hashCode += (this.getAge() * 10000);

        return hashCode;
    }


}
