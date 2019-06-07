import java.util.Scanner;

public class Exam2018January07_5Ladybird {
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

        System.out.print(repStr(" ", n - 2) + "@   @" + "\n"
                + repStr(" ", n - 1) + "\\_/" + "\n"
                + repStr(" ", n - 1) + "/ \\" + "\n"
                + repStr(" ", n - 1) + "|_|" + "\n");
        for (int i = 0; i < n; i++) {
            System.out.println(repStr(" ", n - i - 1) + "/"
                    + repStr(" ", i) + "|"
                    + repStr(" ", i) + "\\"
                    + repStr(" ", n - i - 1));
        }

        int spaces = 0;
        if (n % 2 == 0) {
            spaces = (n / 2) / 2;
        } else {
            spaces = (n / 2) - 1;
        }

        String midRow = "";
        if (n % 2 == 0) {
            midRow = "|" + repStr(" ", spaces) + "@" + repStr(" ", spaces) +
                    "|" + repStr(" ", spaces) + "@" + repStr(" ", spaces) + "|";
        } else {
            midRow = "|" + repStr(" ", spaces) + "@" + repStr(" ", spaces + 1) +
                    "|" + repStr(" ", spaces + 1) + "@" + repStr(" ", spaces) + "|";
        }
        for (int i = 0; i < n / 2; i++) {
            System.out.println(midRow);
        }

        for (int i = 0; i < n / 2; i++) {
            if (n == 2) {
                System.out.print("");
            } else {
                System.out.println(repStr(" ", i) + "\\"
                        + repStr(" ", n - 1 - i)
                        + "|" + repStr(" ", n - 1 - i) + "/"
                        + repStr(" ", i));
            }
        }
        int sp = 0;
        if (n % 2 == 0) {
            sp = n / 2;
        } else {
            sp = n / 2 + 1;
        }
        System.out.println(repStr(" ", sp) + repStr("^", n - sp) + "|"
                + repStr("^", n - sp) + repStr(" ", sp));


    }
}