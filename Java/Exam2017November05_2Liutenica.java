import java.util.Scanner;

public class Exam2017November05_2Liutenica {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double tomato = Double.parseDouble(scanner.nextLine());
        int boxes = Integer.parseInt(scanner.nextLine()),
                jars = Integer.parseInt(scanner.nextLine());

        double totalLut = tomato * 1.0 / 5.0,
                totalJars = totalLut * 1.0 / 0.535,
                totalBoxes = totalJars * 1.0 / jars;

        System.out.printf("Total lutenica: %.0f kilograms.\n", Math.floor(totalLut));
        if (totalBoxes >= boxes) {
            System.out.printf("%.0f boxes left.\n%.0f jars left.\n", Math.floor(totalBoxes - boxes), Math.floor(totalJars - (boxes * jars)));
        } else {
            System.out.printf("%.0f more boxes needed.\n%.0f more jars needed.", Math.floor(boxes - totalBoxes), Math.floor((boxes * jars) - totalJars));
        }
    }
}