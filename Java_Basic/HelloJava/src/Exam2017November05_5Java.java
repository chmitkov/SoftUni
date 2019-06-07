import java.util.Scanner;

public class Exam2017November05_5Java {
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
            System.out.println(repStr(" ", n - 1) + repStr(" ~", 3));
        }

        for (int i = 0; i < n; i++) {
            if (i == 0 || i == n - 1) {
                System.out.println(repStr("=", 3 * n + 5));
            } else if (i == n / 2) {
                System.out.println("|" + repStr("~", n)
                        + "JAVA" + repStr("~", n)
                        + "|" + repStr(" ", n - 1) + "|");
            } else {
                System.out.println("|" + repStr("~", n * 2 + 4)
                        + "|" + repStr(" ", n - 1) + "|");
            }
        }

        for (int i = 0; i < n; i++) {
            System.out.println(repStr(" ", i) + "\\"
                    + repStr("@", (n * 2 + 4) - 2 * i) + "/");
        }

        System.out.println(repStr("=", n * 2 + 6));

    }
}