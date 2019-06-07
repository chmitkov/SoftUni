import java.util.Scanner;

public class Exam2016November20Evening_05Rocket {
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
            System.out.println(repStr(".", (3 * n - 2) / 2 - i) + "/"
                    + repStr(" ", 2 * i) + "\\"
                    + repStr(".", (3 * n - 2) / 2 - i));
        }
        System.out.println(repStr(".", n / 2) + repStr("*", n * 2)
                + repStr(".", n / 2));
        for (int i = 0; i < n * 2; i++) {
            System.out.println(repStr(".", n / 2) + "|" + repStr("\\", n * 2 - 2)
                    + "|" + repStr(".", n / 2));
        }
        for (int i = 0; i < n / 2; i++) {
            System.out.println(repStr(".", n / 2 - i) + "/" + repStr("*", n * 2 - 2 + 2 * i)
                    + "\\" + repStr(".", n / 2 - i));
        }
    }
}