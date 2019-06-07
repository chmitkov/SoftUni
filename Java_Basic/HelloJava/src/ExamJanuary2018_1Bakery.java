import java.util.Scanner;

public class ExamJanuary2018_1Bakery {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double startDought = Double.parseDouble(scanner.nextLine()),
                breadWeight = Double.parseDouble(scanner.nextLine());
        double breadPrice = Double.parseDouble(scanner.nextLine());
        double sellBread = Double.parseDouble(scanner.nextLine()),
                sellCake = Double.parseDouble(scanner.nextLine());
        double nightDought = startDought - (breadWeight * sellBread),
                cakeWeight = breadWeight - (breadWeight * 0.2),
                cakePrice = breadPrice + (breadPrice * 0.25),
                usedDought = startDought + nightDought,
                usedDoughtPrice = ((startDought + nightDought) / 1000) * 4,
                income = (breadPrice * sellBread) + (cakePrice * sellCake) - usedDoughtPrice,
                usedDought2 = Math.round(startDought + nightDought);
        System.out.printf("Pure income: %.02f lv.\nDough used: %.02f g.", income, usedDought2);
    }
}
