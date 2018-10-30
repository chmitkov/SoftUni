package problem_7_Mankind;

public class Worker extends Human {
    private String lastName;
    private double salary;
    private int workHour;

    public Worker(String firstName, String lastName, double salary, int workHour) {
        super(firstName);
        setLastName(lastName);
        setSalary(salary);
        setWorkHour(workHour);
    }

    @Override
    public String getLastName() {
        return this.lastName;
    }

    private void setLastName(String lastName) {
        if (lastName.length() <= 3) {
            throw new IllegalArgumentException("Expected length more than 3 symbols!Argument: lastName");
        }
        this.lastName = lastName;
    }

    private void setWorkHour(int workHour) {
        if (workHour < 1 || workHour > 12) {
            throw new IllegalArgumentException("Expected value mismatch!Argument: workHoursPerDay");
        }
        this.workHour = workHour;
    }

    private void setSalary(double salary) {
        if (salary <= 10) {
            throw new IllegalArgumentException("Expected value mismatch!Argument: weekSalary");
        }
        this.salary = salary;
    }

    @Override
    public String toString() {
        return String.format("First Name: %s\n" +
                        "Last Name: %s\n" +
                        "Week Salary: %.2f\n" +
                        "Hours per day: %d\n" +
                        "Salary per hour: %.2f\n", this.getFirstName(), this.getLastName(), this.salary, this.workHour,
                (this.salary / 7) / this.workHour);
    }
}
