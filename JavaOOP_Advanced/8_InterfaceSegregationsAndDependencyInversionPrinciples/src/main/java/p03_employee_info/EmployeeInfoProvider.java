package p03_employee_info;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class EmployeeInfoProvider implements InfoProvider {

    private Database database;

    public EmployeeInfoProvider(Database database) {

        this.database = database;
    }

    public List<Employee> getEmployeesByName() {
        return this.database.readEmployees().stream()
                .sorted(Comparator.comparing(Employee::getName))
                .collect(Collectors.toList());
    }

    public Iterable<Employee> getEmployeesBySalary() {
        return this.database.readEmployees().stream()
                .sorted(Comparator.comparing(Employee::getSalary))
                .collect(Collectors.toList());
    }
}
