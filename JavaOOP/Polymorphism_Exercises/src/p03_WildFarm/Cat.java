package p03_WildFarm;

import java.text.DecimalFormat;

public class Cat extends Feline {
    private String breed;

    public Cat(String animalName, String animalType, Double animalWeight, String livingRegion, String breed) {
        super(animalName, animalType, animalWeight, livingRegion);
        this.breed = breed;
    }

    public String getBreed() {
        return breed;
    }

    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("#.#########################");
        return String.format("%s[%s, %s, %s, %s, %d]",
                super.getAnimalType(), super.getAnimalName(), this.getBreed(), df.format(super.getAnimalWeight()), this.getLivingRegion(), super.getFoodEaten());
    }

    @Override
    public String makeSound() {
        return "Meowwww";
    }
}
