package p03_WildFarm;

public class Tiger extends Feline {

    public Tiger(String animalName, String animalType, Double animalWeight, String livingRegion) {
        super(animalName,animalType, animalWeight, livingRegion);
    }

    @Override
    public void eat(Food food){
        if(!food.getClass().getSimpleName().equals("Meat")){
            throw new IllegalArgumentException("Tigers are not eating that type of food!");
        }
        super.eat(food);
    }

    @Override
    public String makeSound() {
        return "ROAAR!!!";
    }
}
