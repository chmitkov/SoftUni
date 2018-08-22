import java.util.Scanner;

public class Exam2016November20Morning_05Fox {
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
            System.out.println(repStr("*", i + 1) + "\\" + repStr("-", 2 * n - 1 - 2 * i)
                    + "/" + repStr("*", i + 1));
        }
        for (int i = 0; i < n / 3; i++) {
            System.out.println("|" + repStr("*", n / 2 + i) + "\\"
                    + repStr("*", n - 2 * i) + "/"
                    + repStr("*", n / 2 + i) + "|");
        }
        for (int i = 0; i < n; i++) {
            System.out.println(repStr("-", i + 1) + "\\" + repStr("*", 2 * n - 1 - 2 * i)
                    + "/" + repStr("-", i + 1));
        }
    }
}
