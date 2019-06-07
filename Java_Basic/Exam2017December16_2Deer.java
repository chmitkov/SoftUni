import java.util.Scanner;

public class Exam2017December16_2Deer {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int days = Integer.parseInt(scanner.nextLine()),
                food = Integer.parseInt(scanner.nextLine());
        double deer1 = Double.parseDouble(scanner.nextLine()),
                deer2 = Double.parseDouble(scanner.nextLine()),
                deer3 = Double.parseDouble(scanner.nextLine());

        double needFood = (deer1 + deer2 + deer3) * days;
        if (food >= needFood) {
            System.out.printf("%.0f kilos of food left.", Math.floor(food*1.0 - needFood));
        } else {
            System.out.printf("%.0f more kilos of food are needed.", Math.ceil(needFood - food*1.0));
        }
    }
}