package problem_6_BirthdayCelebrations;

import java.util.Date;

public class Pet implements HavingBirthDate {
    private String name;
    private String birthdate;

    public Pet(String name, String birthdate) {
        this.name = name;
        this.birthdate = birthdate;
    }

    @Override
    public String getDate() {
        return this.birthdate;
    }
}
