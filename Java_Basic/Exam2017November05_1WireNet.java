import java.util.Scanner;

public class Exam2017November05_1WireNet {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int placeLength = Integer.parseInt(scanner.nextLine()),
                placeWidth = Integer.parseInt(scanner.nextLine());
        double wireHeight = Double.parseDouble(scanner.nextLine()),
                pricePerM = Double.parseDouble(scanner.nextLine()),
                weightPerM = Double.parseDouble(scanner.nextLine());

        double placeP = (placeWidth + placeLength) * 2,
                wireS = placeP * wireHeight;
        System.out.printf("%.0f\n%.2f\n%.3f", placeP, (placeP * pricePerM), (wireS * weightPerM));
    }
}