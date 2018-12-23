package problem_08_PetClinics;

import java.util.Arrays;
import java.util.Iterator;

public class Clinic implements Iterable<Room> {

    private String name;
    private Room[] rooms;
    private int addedPetCounter;
    private int leftRoomCounter;
    private int rightRoomCounter;

    public Clinic() {

    }

    public String getName() {
        return name;
    }

     void setName(String name) {
        this.name = name;
    }

    public Room[] getRooms() {
        return rooms;
    }

     void setRooms(int countOfRooms) throws IllegalArgumentException{
        if (countOfRooms % 2 == 0) {
            throw new IllegalArgumentException("Rooms must be odd number!");
        } else {
            this.rooms = new Room[countOfRooms];
        }
    }

    boolean HasEmptyRooms(){
        for (Room room : rooms) {
            if (room == null){
                return true;
            }
        }
        return false;
    }

     void addPetToRoom(Pet pet) {
        int centerRoomIndex = this.rooms.length / 2 + 1;

        if (addedPetCounter == 0) {
            this.rooms[centerRoomIndex].setPet(pet);
        } else if (addedPetCounter % 2 == 0) {
            this.rooms[centerRoomIndex + rightRoomCounter].setPet(pet);
            rightRoomCounter++;
        } else {
            this.rooms[centerRoomIndex - leftRoomCounter].setPet(pet);
            leftRoomCounter++;
        }
        addedPetCounter++;
    }


    @Override
    public Iterator<Room> iterator() {
        return new ClinicIterator();
    }

    private final class ClinicIterator implements Iterator<Room> {
        int counter = rooms.length / 2 + 1;
        int border = rooms.length;

        @Override
        public boolean hasNext() {
            if (this.counter == this.border - 1) {
                counter = 0;
                border = rooms.length / 2;
                return true;
            }
            return this.counter < border;
        }

        @Override
        public Room next() {
            return rooms[counter++];
        }
    }
}
