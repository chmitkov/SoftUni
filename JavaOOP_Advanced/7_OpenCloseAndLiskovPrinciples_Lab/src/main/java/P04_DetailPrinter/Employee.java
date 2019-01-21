package P04_DetailPrinter;

public class Employee implements Printable{
    private String name;

    public Employee(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public void print() {
        System.out.printf("Name: %s%n", this.getName());
    }
}
