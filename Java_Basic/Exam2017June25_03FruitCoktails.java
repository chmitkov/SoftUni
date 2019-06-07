import java.util.Scanner;

public class Exam2017June25_03FruitCoktails {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String fruit = scanner.nextLine().toLowerCase(),
                type = scanner.nextLine().toLowerCase();
        int num = Integer.parseInt(scanner.nextLine());
        double total = 0.0;

        switch (fruit) {
            case "watermelon":
                if ("small".equals(type)) {
                    total = (56 * 2) * num;
                } else {
                    total = (28.70 * 5) * num;
                }
                break;
            case "mango":
                if ("small".equals(type)) {
                    total = (36.66 * 2) * num;
                } else {
                    total = (19.60 * 5) * num;
                }
                break;
            case "pineapple":
                if ("small".equals(type)) {
                    total = (42.1 * 2) * num;
                } else {
                    total = (24.80 * 5) * num;
                }
                break;
            case "raspberry":
                if ("small".equals(type)) {
                    total = (20 * 2) * num;
                } else {
                    total = (15.20 * 5) * num;
                }
                break;
        }
        if (total > 1000) {
            total -= total * 0.5;
        } else if (total >= 400) {
            total -= total * 0.15;
        } else {
            total = total;
        }
        System.out.printf("%.2f lv.", total);
    }
}