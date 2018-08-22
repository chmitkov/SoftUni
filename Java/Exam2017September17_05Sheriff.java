import java.util.Scanner;

public class Exam2017September17_05Sheriff {

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

        String firstAndLast = repStr(".", (n * 3 - 1) / 2) + "x"
                + repStr(".", (n * 3 - 1) / 2),
                afterFirst = repStr(".", (n * 3 - 3) / 2) + "/x\\"
                        + repStr(".", (n * 3 - 3) / 2),
                beforeLast = repStr(".", (n * 3 - 3) / 2) + "\\x/"
                        + repStr(".", (n * 3 - 3) / 2),
                specialRow = repStr(".", (n * 3 - 3) / 2) + "x|x"
                        + repStr(".", (n * 3 - 3) / 2);
        System.out.println(firstAndLast);
        System.out.println(afterFirst);
        System.out.println(specialRow);

        int a = 1;

        for (int i = 0; i < n; i++) {
            if (i <= n / 2) {
                System.out.println(repStr(".", n / 2 - i)
                        + repStr("x", n + i) + "|"
                        + repStr("x", n + i) + repStr(".", n / 2 - i));
            } else {
                System.out.println(repStr(".", a)
                        + repStr("x", (3 * n - 1 - 2 * a) / 2) + "|"
                        + repStr("x", (3 * n - 1 - 2 * a) / 2)
                        + repStr(".", a));
                a += 1;
            }
        }

        System.out.println(afterFirst);
        System.out.println(beforeLast);
        int b = 1;
        for (int i = 0; i < n; i++) {
            if (i <= n / 2) {
                System.out.println(repStr(".", n / 2 - i)
                        + repStr("x", n + i) + "|"
                        + repStr("x", n + i) + repStr(".", n / 2 - i));
            } else {
                System.out.println(repStr(".", b)
                        + repStr("x", (3 * n - 1 - 2 * b) / 2) + "|"
                        + repStr("x", (3 * n - 1 - 2 * b) / 2)
                        + repStr(".", b));
                b += 1;
            }
        }
        System.out.println(specialRow);
        System.out.println(beforeLast);
        System.out.println(firstAndLast);

    }
}