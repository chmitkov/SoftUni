package P04_DetailPrinter;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Employee employee = new Employee("Pesho");

        Iterable<String> docs = new ArrayList<String>() {{
            add("doc1");
            add("doc2");
            add("doc3");
        }};
        Manager manager = new Manager("Gosho",docs);

        Developer developer = new Developer("Stoqn");

        Iterable<Employee> employees = new ArrayList<Employee>(){{
           add(employee);
           add(manager);
           add(developer);
        }};

        DetailsPrinter detailsPrinter = new DetailsPrinter(employees);

        detailsPrinter.printDetails();
    }
}
