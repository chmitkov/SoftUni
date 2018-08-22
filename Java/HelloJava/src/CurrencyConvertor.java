import java.util.Scanner;

public class CurrencyConvertor {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        double amount = Double.parseDouble(scanner.nextLine());
        String curin = scanner.nextLine(),
                curout = scanner.nextLine();

        double bgnToUsd = amount / 1.79549,
                bgnToEur = amount / 1.95583,
                bgnToGbp = amount / 2.53405,

                usdToBgn = amount * 1.79549,
                usdToEur = usdToBgn / 1.95583,
                usdToGbp = usdToBgn / 2.53405,

                eurToBgn = amount * 1.95583,
                eurToUsd = eurToBgn / 1.79549,
                eurToGbp = eurToBgn / 2.53405,

                gbpToBgn = amount * 2.53405,
                gbpToEur = gbpToBgn / 1.95583,
                gbpToUsd = gbpToBgn / 1.79549;


        if (curin.equals("BGN")) {
            if (curout.equals("BGN")) {
                System.out.printf("%.2f BGN", amount);
            } else if (curout.equals("USD")) {
                System.out.printf("%.2f USD", bgnToUsd);
            } else if (curout.equals("EUR")) {
                System.out.printf("%.2f EUR", bgnToEur);
            } else if (curout.equals("GBP")) {
                System.out.printf("%.2f GBP", bgnToGbp);
            }

        } else if (curin.equals("USD")) {
            if (curout.equals("BGN")) {
                System.out.printf("%.2f BGN", usdToBgn);
            } else if (curout.equals("USD")) {
                System.out.printf("%.2f USD", amount);
            } else if (curout.equals("EUR")) {
                System.out.printf("%.2f EUR", usdToEur);
            } else if (curout.equals("GBP")) {
                System.out.printf("%.2f GBP", usdToGbp);
            }

        } else if (curin.equals("EUR")) {
            if (curout.equals("EUR")) {
                System.out.printf("%.2f BGN", eurToBgn);
            } else if (curout.equals("USD")) {
                System.out.printf("%.2f USD", eurToUsd);
            } else if (curout.equals("EUR")) {
                System.out.printf("%.2f EUR", amount);
            } else if (curout.equals("GBP")) {
                System.out.printf("%.2f GBP", eurToGbp);
            }


        } else if (curin.equals("GBP")) {
            if (curout.equals("BGN")) {
                System.out.printf("%.2f BGN", gbpToBgn);
            } else if (curout.equals("USD")) {
                System.out.printf("%.2f USD", gbpToUsd);
            } else if (curout.equals("EUR")) {
                System.out.printf("%.2f EUR", gbpToEur);
            } else if (curout.equals("GBP")) {
                System.out.printf("%.2f GBP", amount);
            }

        }
    }
}
