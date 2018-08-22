import java.util.Scanner;

public class TrapezVolume {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int length = Integer.parseInt(scanner.nextLine());
        int width = Integer.parseInt(scanner.nextLine());
        int height = Integer.parseInt(scanner.nextLine());
        double percent = Double.parseDouble(scanner.nextLine());

        double capacity = (length / 10.0) * (width / 10.0) * (height / 10.0);  //length * width * height / 1000.0
        double realVolume = capacity - capacity * percent / 100;

        System.out.printf("%.3f%n", realVolume);
    }
}
