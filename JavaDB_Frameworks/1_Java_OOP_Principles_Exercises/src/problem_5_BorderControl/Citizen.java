package problem_5_BorderControl;

public class Citizen implements HavingId {
    private String name;
    private int age;
    private String id;

    public Citizen(String name, int age, String id) {
        this.age = age;
        this.id = id;
        this.name = name;
    }

    @Override
    public String getId() {
        return this.id;
    }
}
