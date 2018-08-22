import java.util.Scanner;

public class VegetablesExchange {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double vegetablesPriceKg = Double.parseDouble(scanner.nextLine()),
                fruitsPriceKg = Double.parseDouble(scanner.nextLine());

        int allVegetablesKg = Integer.parseInt(scanner.nextLine()),
                allFruitsKg = Integer.parseInt(scanner.nextLine());

        double income = ((allVegetablesKg*vegetablesPriceKg)+(allFruitsKg*fruitsPriceKg))*1.0/1.94;
        System.out.println(income);
    }
}
