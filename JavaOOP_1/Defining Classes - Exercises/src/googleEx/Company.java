package googleEx;

public class Company {
    private String companyName;
    private String companyDepartment;
    private double salary;

    public Company(String companyName, String companyDepartment, double salary) {
        this.companyName = companyName;
        this.companyDepartment = companyDepartment;
        this.salary = salary;
    }

    public String getCompanyName() {
        return this.companyName;
    }

    public String getCompanyDepartment() {
        return this.companyDepartment;
    }

    public double getSalary() {
        return this.salary;
    }
    @Override
    public String toString() {
        return String.format("%s %s %.2f%n", getCompanyName(),getCompanyDepartment(),getSalary());
    }
}
