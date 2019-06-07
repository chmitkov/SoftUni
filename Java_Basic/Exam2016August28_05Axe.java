import java.util.Scanner;

public class Exam2016August28_05Axe {
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

        for (int i = 0; i < n; i++) {
            System.out.println(repStr("-", 3 * n) + "*" + repStr("-", i)
                    + "*" + repStr("-", 2 * n - 2 - i));
        }
        for (int i = 0; i < n / 2; i++) {
            System.out.println(repStr("*", 3 * n) + "*" + repStr("-", n - 1)
                    + "*" + repStr("-", n - 1));
        }
        for (int i = 0; i < n / 2; i++) {
            if (i == n / 2 - 1) {
                System.out.println(repStr("-", 3 * n - i) + "*" + repStr("*", n - 1 + 2 * i)
                        + "*" + repStr("-", n - 1 - i));
            } else {
                System.out.println(repStr("-", 3 * n - i) + "*" + repStr("-", n - 1 + 2 * i)
                        + "*" + repStr("-", n - 1 - i));
            }

        }
    }
}