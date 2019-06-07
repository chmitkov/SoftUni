import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class _1ParkingLot {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Set<String> parking = new HashSet<>();

        String input = br.readLine();

        while (!"END".equals(input)){
            String [] commands = input.split(", ");

            String direction = commands[0];
            String plate = commands[1];

            if (direction.equals("IN")){
                parking.add(plate);
            }else{
                if(parking.contains(plate)){
                    parking.remove(plate);
                }
            }
            input = br.readLine();
        }
        if (parking.isEmpty()){
            System.out.println("Parking Lot is Empty");
        }else{
            parking.forEach(System.out::println);
        }
    }
}
