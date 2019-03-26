package p03_WildFarm;

public class Zebra extends Mammal {
    public Zebra(String animalName, String animalType, Double animalWeight ,String livingRegion) {
        super(animalName,animalType, animalWeight, livingRegion);
    }

    @Override
    public void eat(Food food){
        if(!food.getClass().getSimpleName().equals("Vegetable")){
            throw new IllegalArgumentException("Zebras are not eating that type of food!");
        }
        super.eat(food);
    }

    @Override
    public String makeSound() {
        return "Zs";
    }
}
