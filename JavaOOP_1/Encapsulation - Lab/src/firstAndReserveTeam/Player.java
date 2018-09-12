package firstAndReserveTeam;

public class Player {
    private String firstName;
    private String lastName;
    private int age;
    private double salary;

    public Player(String firstName, String lastName, int age, double salary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.salary = salary;
    }

    public int getAge() {
        return this.age;
    }


}
