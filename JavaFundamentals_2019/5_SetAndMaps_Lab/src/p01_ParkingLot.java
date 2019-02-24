import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class p01_ParkingLot {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Set<String> parking = new HashSet<>();

        String line;
        while (!"END".equals(line = br.readLine())) {
            String[] command = line.split(",\\s+");

            switch (command[0]) {
                case "IN":
                    parking.add(command[1]);
                    break;
                case "OUT":
                    parking.remove(command[1]);
                    break;
            }

        }

        if (parking.isEmpty()) {
            System.out.println("Parking Lot is Empty");
            return;
        }

        parking.forEach(System.out::println);
    }
}
