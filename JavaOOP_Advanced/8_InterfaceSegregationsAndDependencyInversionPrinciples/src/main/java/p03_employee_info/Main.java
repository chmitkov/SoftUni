package p03_employee_info;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

//        List<Employee> employees = new ArrayList<Employee>(){{
//           add(new Employee("Emp1", 10));
//           add(new Employee("Emp2", 10));
//           add(new Employee("Emp3", 10));
//           add(new Employee("Emp4", 10));
//           add(new Employee("Emp5", 10));
//        }};
//
//        Database database = new EmployeeDatabase();

        EmployeeInfoProvider employeeInfo =
                new EmployeeInfoProvider(new EmployeeDatabase());
        ConsoleFormatter formatter = new ConsoleFormatter();

        String output = formatter.format(employeeInfo.getEmployeesByName());
        System.out.println(output);
    }
}
