import java.util.Scanner;

public class Exam2017May07_05Crown {
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

        String firstRow = "@" + repStr(" ", n - 2) + "@" + repStr(" ", n - 2) + "@",
                lastRow = repStr("*", 2 * n - 1);
        System.out.println(firstRow);
        int a = 1;
        for (int i = 0; i < n / 2 + 1; i++) {
            if (i == 0) {
                System.out.println("**" + repStr(" ", n - 3) + "*"
                        + repStr(" ", n - 3) + "**");
            } else if (i == n / 2 - 1) {
                System.out.println("*" + repStr(".", n / 2 - 1) + "*"
                        + repStr(".", n - 3) + "*" + repStr(".", n / 2 - 1)
                        + "*");

            } else if (i == n / 2) {
                System.out.println("*" + repStr(".", n / 2) + repStr("*", (n - 4) / 2)
                        + "." + repStr("*", (n - 4) / 2) + repStr(".", n / 2)
                        + "*");
            } else {
                System.out.println("*" + repStr(".", i) + "*" + repStr(" ", n - 3 - 2 * i)
                        + "*" + repStr(".", a) + "*" + repStr(" ", n - 3 - 2 * i)
                        + "*" + repStr(".", i) + "*");
                a += 2;
            }

        }
        System.out.println(lastRow);
        System.out.println(lastRow);

    }
}