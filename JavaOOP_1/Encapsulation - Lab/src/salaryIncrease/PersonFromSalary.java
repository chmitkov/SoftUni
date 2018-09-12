package salaryIncrease;

import java.text.DecimalFormat;

public class PersonFromSalary {
    private String firstName;
    private String lastName;
    private int age;
    private double salary;
    private static DecimalFormat df = new DecimalFormat("#.0###############");

    public PersonFromSalary(String firstName, String lastName, Integer age,
                            Double salary) {
        setFirstName(firstName);
        setLastName(lastName);
        setAge(age);
        setSalary(salary);
    }

    private void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    private void setLastName(String lastName) {
        this.lastName = lastName;
    }

    private void setAge(int age) {
        this.age = age;
    }

    private void setSalary(double salary) {
        this.salary = salary;
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

    public double getSalary(){
        return this.salary;
    }

    public void increaseSalary(double bonus){
        if (this.getAge()<30){
            bonus/=2;
        }
        this.setSalary(this.getSalary()+this.getSalary()*(bonus/100));
    }

    @Override
    public String toString() {
        return String.format("%s %s gets %s leva",
                getFirstName(), getLastName(),
                df.format(getSalary()));
    }
}