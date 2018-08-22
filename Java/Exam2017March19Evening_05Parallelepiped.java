import java.util.Scanner;

public class Exam2017March19Evening_05Parallelepiped {
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

        String firstRow = "+" + repStr("~", n - 2) + "+" + repStr(".", n * 2 + 1),
                lastRow = repStr(".", n * 2 + 1) + "+" + repStr("~", n - 2) + "+";
        System.out.println(firstRow);
        for (int i = 0; i < 4 * n + 2; i++) {
            if (i < (4 * n + 2) / 2) {
                System.out.println("|" + repStr(".", i) + "\\" + repStr("~", n - 2)
                        + "\\" + repStr(".", n * 2 - i));
            } else {
                System.out.println(repStr(".", i - (4 * n + 2) / 2) + "\\"
                        + repStr(".", n * 2 - (i - (4 * n + 2) / 2)) + "|"
                        + repStr("~", n - 2) + "|");
            }
        }
        System.out.println(lastRow);
    }
}