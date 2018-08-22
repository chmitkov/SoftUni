import java.util.Scanner;

public class Exam2017March19Morning_05Hourglass {
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

        String firstAndLast = repStr("*", 2 * n + 1);
        System.out.println(firstAndLast);
        int a = 0;
        int b = 1;
        for (int i = 0; i < n * 2 - 1; i++) {
            if (i == 0) {
                System.out.println(".*" + repStr(" ", 2 * n - 3) + "*.");
            } else if (i == n - 1) {
                System.out.println(repStr(".", n) + "*" + repStr(".", n));
            } else if (i == 2 * n - 2) {
                System.out.println(".*" + repStr("@", 2 * n - 3) + "*.");
            } else if (i < n - 1) {
                System.out.println(repStr(".", i + 1) + "*" + repStr("@", (n * 2 + 1) - 6 - a)
                        + "*" + repStr(".", i + 1));
                a += 2;
            } else {
                System.out.println(repStr(".", n - b) + "*" + repStr(" ", b - 1) + "@"
                        + repStr(" ", b - 1) + "*" + repStr(".", n - b));
                b += 1;
            }
        }
        System.out.println(firstAndLast);
    }
}