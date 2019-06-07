import java.util.Scanner;

public class Exam2017December16_05ChristmasToy {

    static String repStr(String strToRep, int count) {
        String text = "";
        for (int i = 0; i < count; i++) {
            text += strToRep;

        }
        return text;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        String firstAndLast = repStr("-", n * 2) + repStr("*", n)
                + repStr("-", n * 2);

        System.out.println(firstAndLast);

        for (int i = 1; i <= n / 2; i++) {
            System.out.println(repStr("-", n * 2 - 2 * i)
                    + repStr("*", i) + repStr("&", n + 2 * i)
                    + repStr("*", i) + repStr("-", n * 2 - 2 * i));
        }
        int a = 0;
        for (int i = 1; i <= n / 2; i++) {
            System.out.println(repStr("-", n - i) + "**"
                    + repStr("~", (3 * n - 2) + a) + "**"
                    + repStr("-", n - i));
            a += 2;
        }

        String midRow = repStr("-", n / 2) + "*" + repStr("|", n * 4 - 2)
                + "*" + repStr("-", n / 2);
        System.out.println(midRow);

        int spaces = 5 * n - 4 - n;
        for (int i = 0; i < n / 2; i++) {
            System.out.println(repStr("-", n / 2 + i) + "**"
                    + repStr("~", spaces - 2 * i) + "**"
                    + repStr("-", n / 2 + i));
        }
        for (int i = 0; i < n / 2; i++) {
            System.out.println(repStr("-", n + 2 * i)
                    + repStr("*", n / 2 - i) + repStr("&", n * 2 - 2 * i)
                    + repStr("*", n / 2 - i) + repStr("-", n + 2 * i));
        }
        System.out.println(firstAndLast);
    }
}