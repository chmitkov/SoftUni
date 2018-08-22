import java.util.Scanner;

public class CelsiusToFahrenheit {
    public static void main(String[] arguments){
        Scanner scanner = new Scanner(System.in);

        double cel = Double.parseDouble(scanner.nextLine()),
                far = cel * 1.8 + 32;
        System.out.printf("%.2f", far);
    }
}
