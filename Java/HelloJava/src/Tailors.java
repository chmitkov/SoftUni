import java.util.Scanner;

public class Tailors {
    public static void main(String[] arguments){
        Scanner scanner = new Scanner (System.in);

        double rectangleTable = Double.parseDouble(scanner.nextLine()),
                tableLeength = Double.parseDouble(scanner.nextLine()),
                tableWidth = Double.parseDouble(scanner.nextLine());
        double coverArea = rectangleTable *(tableLeength + 2 * 0.30) *(tableWidth + 2 * 0.30),
                diamondArea = rectangleTable*(tableLeength/2)*(tableWidth/2),
                coverPriceInUsd = (coverArea * 7) + (diamondArea * 9),
                usdToBgn = coverPriceInUsd * 1.85;
        System.out.printf("%.2f USD \n%.2f BGN", coverPriceInUsd, usdToBgn);
    }
}
