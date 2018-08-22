import java.util.Scanner;

public class Exam2017May07_01AlcoholMarket {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double whiskeyPrice = Double.parseDouble(scanner.nextLine()),
                beer = Double.parseDouble(scanner.nextLine()),
                wine = Double.parseDouble(scanner.nextLine()),
                rakia = Double.parseDouble(scanner.nextLine()),
                whiskey = Double.parseDouble(scanner.nextLine());

        double rakiaP = whiskeyPrice / 2,
                wineP = rakiaP - rakiaP * 0.4,
                beerP = rakiaP - rakiaP * 0.8,
                total = beer * beerP + wine * wineP + rakia * rakiaP
                        + whiskey * whiskeyPrice;
        System.out.printf("%.2f", total);
    }
}