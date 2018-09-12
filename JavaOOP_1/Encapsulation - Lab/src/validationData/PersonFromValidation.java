package validationData;

import java.text.DecimalFormat;

public class PersonFromValidation {
    private String firstName;
    private String lastName;
    private int age;
    private double salary;
    private static DecimalFormat df = new DecimalFormat("#.0###############");

    public PersonFromValidation(String firstName, String lastName, Integer age,
                                Double salary) {
        setFirstName(firstName);
        setLastName(lastName);
        setAge(age);
        setSalary(salary);
    }

    private void setFirstName(String firstName) {
        if (firstName.length() < 3) {
            throw new IllegalArgumentException("First name cannot be less than 3 symbols");
        }
        this.firstName = firstName;
    }

    private void setLastName(String lastName) {
        if (lastName.length() < 3) {
            throw new IllegalArgumentException("Last name cannot be less than 3 symbols");
        }
        this.lastName = lastName;
    }

    private void setAge(int age) {
        if (age <= 0) {
            throw new IllegalArgumentException("Age cannot be zero or negative integer");
        }
        this.age = age;
    }

    private void setSalary(double salary) {
        if (salary < 460) {
            throw new IllegalArgumentException("Salary cannot be less than 460 leva");
        }
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

    public double getSalary() {
        return this.salary;
    }

    public void increaseSalary(double bonus) {
        if (this.getAge() < 30) {
            bonus /= 2;
        }
        this.setSalary(this.getSalary() + this.getSalary() * (bonus / 100));
    }

    @Override
    public String toString() {
        return String.format("%s %s gets %s leva",
                getFirstName(), getLastName(),
                df.format(getSalary()));
    }

}
