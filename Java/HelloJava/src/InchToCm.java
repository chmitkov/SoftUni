import java.util.Scanner;

public class InchToCm {
    public static void main(String[] arguments){
        Scanner scanner = new Scanner(System.in);

        double inch = Double.parseDouble(scanner.nextLine()),
                cm = inch * 2.54;
        System.out.println(cm);
    }
}
