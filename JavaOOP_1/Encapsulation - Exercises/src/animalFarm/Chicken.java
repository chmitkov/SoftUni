package animalFarm;

import java.security.PublicKey;

public class Chicken {
    private String name;
    private int age;

    public Chicken(String name, Integer age) {
        setName(name);
        setAge(age);
    }

    private void setName(String name) {
        if (name.trim().length() < 1) {
            throw new IllegalArgumentException("Name cannot be empty.");
        }
        this.name = name;
    }

    private void setAge(int age) {
        if (age < 0 || age > 15) {
            throw new IllegalArgumentException("Age should be between 0 and 15.");
        }
        this.age = age;
    }

    private String productPerDay() {
        String result = "";
        if (this.age >= 0 && this.age < 6) {
            result = "2";
        } else if (this.age > 5 && this.age < 12) {
            result = "1";
        } else {
            result = "0.75";
        }
        return result;
    }

    @Override
    public String toString() {
        return String.format("Chicken %s (age %d) can produce %s eggs per day.",
                this.name, this.age, productPerDay());
    }
}
