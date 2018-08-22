import java.util.Scanner;

public class UsdToBgn {
    public static void main (String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        double usd = Double.parseDouble(scanner.nextLine()),
                bgn = usd * 1.79549;

        System.out.printf("%.2f BGN",bgn);
    }
}
