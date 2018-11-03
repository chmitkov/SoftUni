package problem_6_BirthdayCelebrations;

import java.util.Date;

public class Citizen implements HavingId, HavingBirthDate {
    private String name;
    private int age;
    private String id;
    private String birthdate;

    public Citizen(String name, int age, String id, String birthdate) {
        this.age = age;
        this.id = id;
        this.name = name;
        this.birthdate = birthdate;
    }

    @Override
    public String getId() {
        return this.id;
    }

    @Override
    public String getDate() {
        return this.birthdate;
    }
}
