import java.util.Scanner;

public class Travel {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double budget = Double.parseDouble(scanner.nextLine());
        String season = scanner.nextLine();

        if (budget <= 100) {
            switch (season) {
                case "summer":
                    System.out.printf("Somewhere in Bulgaria\nCamp – %f\n", (budget * 0.3));
                    break;
                case "winter":

                    break;
            }

        } else if (budget <= 1000) {
            switch (season) {
                case "summer":

                    break;
                case "winter":

                    break;
            }
        } else {
            switch (season) {
                case "summer":

                    break;
                case "winter":

                    break;
            }
        }
    }
}
