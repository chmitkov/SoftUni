package catLady;

public class Cat {
    private String type;
    private String name;
    private double specialAbility;

    public Cat(String type, String name, double specialAbility) {
        this.type = type;
        this.name = name;
        this.specialAbility = specialAbility;
    }

    public String getName() {
        return this.name;
    }

    @Override
    public String toString(){
        return String.format("%s %s %.2f", this.type,this.name,this.specialAbility);
    }
}
