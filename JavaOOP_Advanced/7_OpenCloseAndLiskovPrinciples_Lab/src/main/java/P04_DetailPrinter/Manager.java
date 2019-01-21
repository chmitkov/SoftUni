package P04_DetailPrinter;

public class Manager extends Employee implements Printable {

    private Iterable<String> documents;

    public Manager(String name, Iterable<String> documents) {
        super(name);
        this.documents = documents;
    }

    @Override
    public void print() {
        System.out.printf("Name: %s%nDocuments: %s%n",
                super.getName(), String.join(", ", this.documents));
    }
}
