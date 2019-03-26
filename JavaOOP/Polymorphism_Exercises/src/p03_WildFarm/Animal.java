package p03_WildFarm;

public abstract class Animal {
    private String animalName;
    private String animalType;
    private Double animalWeight;
    private Integer foodEaten;

    public Animal() {
    }

    public Animal(String animalName, String animalType, Double animalWeight) {
        this.animalName = animalName;
        this.animalType = animalType;
        this.animalWeight = animalWeight;
        this.foodEaten = 0;
    }

    public String getAnimalName() {
        return animalName;
    }

    public String getAnimalType() {
        return animalType;
    }

    public Double getAnimalWeight() {
        return animalWeight;
    }

    public Integer getFoodEaten() {
        return foodEaten;
    }

    private void setFoodEaten(Integer foodEaten) {
        this.foodEaten = foodEaten;
    }

    public abstract String makeSound();

    public void eat(Food food){
        this.setFoodEaten(this.getFoodEaten()+food.getQuantity());
    }
}
