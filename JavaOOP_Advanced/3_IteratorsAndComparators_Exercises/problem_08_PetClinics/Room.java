package problem_08_PetClinics;

public class Room {
    private Pet pet;

    public Room(Pet pet) {
        this.setPet(pet);
    }

    public Pet getPet() {
        return pet;
    }

    void setPet(Pet pet) {
        this.pet = pet;
    }
}
