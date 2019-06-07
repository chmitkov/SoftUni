import java.util.Scanner;

public class Exam2017July23_05Cup {
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

        for (int i = 0; i < n / 2; i++) {
            System.out.println(repStr(".", n + i) + repStr("#", 3 * n - 2 * i)
                    + repStr(".", n + i));
        }

        for (int i = 0; i < n / 2 + 1; i++) {
            System.out.println(repStr(".", (n + n / 2) + i) + "#"
                    + repStr(".", (n * 2 - 2) - 2 * i) + "#"
                    + repStr(".", (n + n / 2) + i));
        }

        String midRow = repStr(".", 2 * n) + repStr("#", n) + repStr(".", 2 * n);
        System.out.println(midRow);

        for (int i = 0; i < n + 2; i++) {
            if (i == n / 2) {
                System.out.println(repStr(".", (5 * n - 10) / 2)
                        + "D^A^N^C^E^"
                        + repStr(".", (5 * n - 10) / 2));
            } else {
                System.out.println(repStr(".", 2 * n - 2) + repStr("#", n + 4)
                        + repStr(".", 2 * n - 2));
            }
        }
    }
}