import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class _12VehiclePark {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        ArrayList<String> cars = new ArrayList<String>(Arrays.asList(scanner.nextLine().split("\\s+")));
        int soldCounter = 0;
        String input = scanner.nextLine();

        while (!input.equals("End of customers!")) {
            String[] commands = input.split(" ");
            String carT = (input.charAt(0) + "").toLowerCase();
            int seats = Integer.parseInt(commands[2]);
            String neededCar = carT + seats;
            String result = "";
            for (int i = 0; i < cars.size(); i++) {
                if (neededCar.equals(cars.get(i))) {
                    int currPrice = neededCar.charAt(0) * Integer.parseInt(neededCar.substring(1));
                    soldCounter++;
                    result = String.format("Yes, sold for %d$", currPrice);
                    cars.remove(i);
                    break;
                }
            }
            System.out.println(result.isEmpty()
                    ? "No"
                    : result
            );
            input = scanner.nextLine();
        }
        if(cars.isEmpty()){
            System.out.printf("Vehicles sold: %d",soldCounter);
        }else{
            System.out.printf("Vehicles left: "+String.join(", ",cars)+"\n" +
                    "Vehicles sold: %d",soldCounter);
        }


    }
}
