import java.util.Scanner;

public class Exam2018January07_4Rate {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double money = Double.parseDouble(scanner.nextLine());
        int months = Integer.parseInt(scanner.nextLine());
        double simpleRate = 0.0,
                complexRate = money;
        String better = "";
        double diff = 0.0;

        simpleRate = money + (money * ((months * 3) * 0.01));
        for (int i = 0; i < months; i++) {
            complexRate = complexRate + (complexRate * 0.027);

        }
        if (simpleRate > complexRate) {
            better = "simple";
        } else {
            better = "complex";
        }
        diff = Math.abs(simpleRate - complexRate);
        System.out.printf("Simple interest rate: %.2f lv.\n", simpleRate);
        System.out.printf("Complex interest rate: %.2f lv.\n", complexRate);
        System.out.printf("Choose a %s interest rate. You will win %.2f lv.", better, diff);
    }
}
