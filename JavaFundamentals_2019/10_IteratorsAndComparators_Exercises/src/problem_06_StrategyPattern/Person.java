package problem_06_StrategyPattern;

public class Person {
    private String name;
    private int age;

    Person(String name, int age) {
        this.setName(name);
        this.setAge(age);
    }

    String getName() {
        return name;
    }

    private void setName(String name) {
        this.name = name;
    }

     int getAge() {
        return age;
    }

    private void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return String.format("%s %d", this.getName(), this.getAge());
    }
}
