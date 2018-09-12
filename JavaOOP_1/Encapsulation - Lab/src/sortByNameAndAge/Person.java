package sortByNameAndAge;

public class Person {
    private String firstName;
    private String lastName;
    private int age;

    public Person(String firstName,String lastName,Integer age){
        setFirstName(firstName);
        setLastName(lastName);
        setAge(age);
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public int getAge() {
        return this.age;
    }

    @Override
    public String toString(){
        return String.format("%s %s is %d years old.",
                getFirstName(),getLastName(),getAge());
    }
}
