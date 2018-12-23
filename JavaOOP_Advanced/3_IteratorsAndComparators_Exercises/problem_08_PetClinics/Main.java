package problem_08_PetClinics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int counter = Integer.parseInt(br.readLine());

        List<Pet> pets = new ArrayList<>();
        List<Clinic> clinics = new ArrayList<>();

        while (counter-- > 0) {
            String[] commands = br.readLine().split("\\s+");

            switch (commands[0]) {
                case "Create":
                    if ("Pet".equals(commands[1])) {
                        Pet currentPet = new Pet(commands[2], Integer.valueOf(commands[3]), commands[4]);
                        pets.add(currentPet);
                    } else if ("Clinic".equals(commands[1])) {
                        Clinic currentClinic = new Clinic();
                        currentClinic.setName(commands[2]);
                        try {
                            currentClinic.setRooms(Integer.parseInt(commands[3]));
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }
                        clinics.add(currentClinic);
                    }
                    break;

                case "Add":
                    Clinic tempClinic = clinics.stream()
                            .filter(x -> x.getName().equals(commands[2]))
                            .findFirst()
                            .get();
                    Pet tempPet = pets.stream()
                            .filter(x -> x.getName().equals(commands[1]))
                            .findFirst()
                            .get();

                    tempClinic.addPetToRoom(tempPet);
                    break;

                case "Release":
                     clinics.stream()
                            .filter(x->x.getName().equals(commands[1]))
                            .findFirst()
                            .get()
                            .iterator()
                            .forEachRemaining(System.out::println);
                    break;

                case "HasEmptyRooms":
                    System.out.println(
                            clinics.stream()
                                    .filter(x -> x.getName().equals(commands[1]))
                                    .findFirst()
                                    .get()
                                    .HasEmptyRooms());
                    break;

                case "Print":
                    if (commands.length == 2) {
                        Room[] rooms = clinics.stream()
                                .filter(x -> x.getName().equals(commands[1]))
                                .findFirst()
                                .get()
                                .getRooms();
                        for (Room room : rooms) {
                            System.out.println(room);
                        }
                    } else {
                        Clinic neededClinic = clinics.stream()
                                .filter(x -> x.getName().equals(commands[1]))
                                .findFirst()
                                .get();
                        System.out.println(neededClinic.getRooms()[Integer.valueOf(commands[2])]);
                    }
                    break;
            }

        }
    }
}
