import java.util.Scanner;

public class Exam2017December17_5ChristmasSock {
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

        System.out.println("|" + repStr("-", n * 2) + "|");
        System.out.println("|" + repStr("*", n * 2) + "|");
        System.out.println("|" + repStr("-", n * 2) + "|");

        int z = 2;

        for (int i = n - 1; i >= 1; i--) {
            System.out.println("|" + repStr("-", i)
                    + repStr("~", z)
                    + repStr("-", i) + "|");
            z += 2;
        }

        int width = n * 2 + 2;
        for (int i = 2; i < n; i++) {
            System.out.println("|" + repStr("-", i)
                    + repStr("~", (width - 2 - 2 * i))
                    + repStr("-", i) + "|");
        }

        int firstLength = 3 + (n - 1) + (n - 2),
                allLength = (3 * n + 3) - firstLength;

        String row = "\\" + repStr(".", width - 1) + "\\";

        for (int i = 0; i <= n + 2; i++) {
            if (i == n / 2) {
                System.out.println(repStr("-", i) + "\\"
                        + repStr(".", (width - 6) / 2)
                        + "MARRY"
                        + repStr(".", (width - 6) / 2)
                        + "\\");
            } else if (i == n / 2 + 2) {
                System.out.println(repStr("-", i) + "\\"
                        + repStr(".", (width - 6) / 2)
                        + "X-MAS"
                        + repStr(".", (width - 6) / 2)
                        + "\\");
            } else if (i == n + 2) {
                System.out.println(repStr("-", i)
                        + "\\" + repStr("_", width - 1) + ")");
            } else {
                System.out.println(repStr("-", i) + row);
            }
        }


    }
}