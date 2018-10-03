import java.util.Scanner;

public class _5Orders {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String typeOfProduct = scanner.nextLine();
        int count = Integer.parseInt(scanner.nextLine());

        getMyOrder(typeOfProduct, count);

    }

    private static void getMyOrder(String typeOfProduct, int count) {
        double sum = 0;
        switch (typeOfProduct) {
            case "coffee":
                sum = count * 1.5;
                break;
            case "water":
                sum = count;
                break;
            case "coke":
                sum = count * 1.4;
                break;
            case "snacks":
                sum = count * 2;
                break;
        }

        System.out.printf("%.2f", sum);
    }
}
