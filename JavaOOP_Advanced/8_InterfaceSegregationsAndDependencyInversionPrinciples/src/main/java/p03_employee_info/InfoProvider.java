package p03_employee_info;

import java.util.List;

public interface InfoProvider {

    List<Employee> getEmployeesByName();

    Iterable<Employee> getEmployeesBySalary();
}
