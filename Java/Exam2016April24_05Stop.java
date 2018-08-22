import java.util.Scanner;

public class Exam2016April24_05Stop {
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

        String firstRow = repStr(".", n + 1) + repStr("_", 2 * n + 1) + repStr(".", n + 1);
        System.out.println(firstRow);
        for (int i = 0; i <= n; i++) {
            if (i == n) {
                System.out.println(repStr(".", n - i) + "//"
                        + repStr("_", (2 * n - 1 + 2 * i - 5) / 2)
                        + "STOP!"
                        + repStr("_", (2 * n - 1 + 2 * i - 5) / 2)
                        + "\\\\" + repStr(".", n - i));
            } else {
                System.out.println(repStr(".", n - i) + "//" + repStr("_", 2 * n - 1 + 2 * i)
                        + "\\\\" + repStr(".", n - i));
            }
        }
        for (int i = 0; i < n; i++) {
            System.out.println(repStr(".", i) + "\\\\" + repStr("_", n * 4 - 1 - 2 * i)
                    + "//" + repStr(".", i));

        }
    }}