package p03_WildFarm;

import java.text.DecimalFormat;

public abstract class Mammal extends Animal{
    private String livingRegion;

    public Mammal(String animalName, String animalType, Double animalWeight, String livingRegion) {
        super(animalName,animalType,animalWeight);
        this.livingRegion = livingRegion;
    }

    public String getLivingRegion() {
        return livingRegion;
    }

    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("#.#########################");
        return String.format("%s[%s, %s, %s, %d]",
                super.getAnimalType(), super.getAnimalName(), df.format(super.getAnimalWeight()), this.getLivingRegion(), super.getFoodEaten());
    }
}
