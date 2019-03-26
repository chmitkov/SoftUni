package p03_WildFarm;

public class Mouse extends Mammal {
    public Mouse(String animalName, String animalType, Double animalWeight ,String livingRegion) {
        super(animalName,animalType, animalWeight, livingRegion);
    }

    @Override
    public void eat(Food food){
        if(!food.getClass().getSimpleName().equals("Vegetable")){
            throw new IllegalArgumentException("Mouses are not eating that type of food!");
        }
        System.out.println("A cheese was just eaten!");
        super.eat(food);
    }

    @Override
    public String makeSound() {
        return "SQUEEEAAAK!";
    }
}
