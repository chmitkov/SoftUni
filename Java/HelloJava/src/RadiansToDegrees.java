import java.util.Scanner;

public class RadiansToDegrees {
    public static void main(String[] arguments){
        Scanner scanner = new Scanner(System.in);

        double rad = Double.parseDouble(scanner.nextLine()),
                deg = Math.round(Math.toDegrees(rad));
        System.out.printf("%f",deg);
    }
}
