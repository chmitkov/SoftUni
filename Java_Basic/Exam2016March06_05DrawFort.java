import java.util.Scanner;

public class Exam2016March06_05DrawFort {
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
            if (i == 0) {
                System.out.println("/" + repStr("^", n / 2) + "\\"
                        + repStr("_", 2 * n - (4 + (n / 2) * 2))
                        + "/" + repStr("^", n / 2) + "\\");
            } else if (i == n - 2) {
                System.out.println("|" + repStr(" ", n / 2 + 1)
                        + repStr("_", 2 * n - (4 + (n / 2) * 2))
                        + repStr(" ", n / 2 + 1) + "|");
            } else if (i == n - 1) {
                System.out.println("\\" + repStr("_", n / 2) + "/"
                        + repStr(" ", 2 * n - (4 + (n / 2) * 2))
                        + "\\" + repStr("_", n / 2) + "/");
            } else {
                System.out.println("|" + repStr(" ", n * 2 - 2) + "|");
            }
        }
    }
}