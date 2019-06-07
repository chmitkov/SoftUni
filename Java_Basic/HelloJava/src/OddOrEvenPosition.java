import java.text.DecimalFormat;
import java.util.Scanner;

public class OddOrEvenPosition {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double numbers = Double.parseDouble(scanner.nextLine()),
                oddSum = 0,
                oddMin = Integer.MAX_VALUE,
                oddMax = Integer.MIN_VALUE,
                evenSum = 0,
                evenMin = Integer.MAX_VALUE,
                evenMax = Integer.MIN_VALUE;

        for (int i = 1; i <= numbers; i++) {
            double num = Double.parseDouble(scanner.nextLine());
            if (i % 2 == 0) {
                evenSum += num;
                if (num > evenMax) {
                    evenMax = num;
                }
                if (num < evenMin) {
                    evenMin = num;
                }
            } else {
                oddSum += num;
                if (num > oddMax) {
                    oddMax = num;
                }
                if (num < oddMin) {
                    oddMin = num;
                }
            }
        }

        DecimalFormat df = new DecimalFormat("#.###");

        System.out.printf("OddSum=%s,\n", df.format(oddSum));
        System.out.printf(oddMin == Integer.MAX_VALUE ? "OddMin=No,\n" : "OddMin=%s,\n", df.format(oddMin));
        System.out.printf(oddMax == Integer.MIN_VALUE ? "OddMax=No,\n" : "OddMax=%s,\n", df.format(oddMax));

        System.out.printf("EvenSum=%s,\n", df.format(evenSum));
        System.out.printf(evenMin == Integer.MAX_VALUE ? "EvenMin=No,\n" : "EvenMin=%s,\n", df.format(evenMin));
        System.out.printf(evenMax == Integer.MIN_VALUE ? "EvenMax=No\n" : "EvenMax=%s\n", df.format(evenMax));


    }
}
