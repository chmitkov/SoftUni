package p03_employee_info;

public class Employee {

    private String name;
    private int salary;

    public Employee(String name, int salary) {
        this.name = name;
        this.salary = salary;
    }

    String getName() {
        return name;
    }

    int getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return this.getName() + " - " + this.getSalary();
    }
}
