package problem_05_ComparingObjects;

public class Person implements Comparable<Person> {

    private String name;
    private Integer age;
    private String town;

    public Person(String name, Integer age, String town) {
        this.setName(name);
        this.setAge(age);
        this.setTown(town);
    }

    private String getName() {
        return name;
    }

    private void setName(String name) {
        this.name = name;
    }

    private Integer getAge() {
        return age;
    }

    private void setAge(Integer age) {
        this.age = age;
    }

    private String getTown() {
        return town;
    }

    private void setTown(String town) {
        this.town = town;
    }

    @Override
    public int compareTo(Person otherPerson) {
        if (this.getName().equals(otherPerson.getName())) {
            if (this.getAge() - otherPerson.getAge() == 0) {
                return this.getTown().compareTo(otherPerson.getTown());
            }
            return this.getAge() - otherPerson.getAge();
        }
        return this.getName().compareTo(otherPerson.getName());
    }
}
