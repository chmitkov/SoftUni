import java.util.Scanner;

public class Exam2017March18_05SoftUniLogo {
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
        int height = 4 * n - 2;
        int width = 12 * n - 5;
        int dots = 2;

        for (int i = 0; i < height; i++) {
            if (i == height / 2) {
                System.out.println(repStr("#", width));
            } else if (i < n * 2 - 1) {
                System.out.println(repStr(".", (width - (1 + 6 * i)) / 2)
                        + repStr("#", 1 + 6 * i)
                        + repStr(".", (width - (1 + 6 * i)) / 2));
            } else if (i == height - 1) {
                System.out.println("@" + repStr(".", (width - 6 * n) / 2 - 1)
                        + repStr("#", 6 * n + 1)
                        + repStr(".", (width - 6 * n) / 2));
            } else if (i > height - n - 1 && i != height - 1) {
                System.out.println("|" + repStr(".", (width - 6 * n) / 2 - 1)
                        + repStr("#", 6 * n + 1)
                        + repStr(".", (width - 6 * n) / 2));
            } else {
                System.out.println("|" + repStr(".", dots)
                        + repStr("#", width - 2 * dots - 2)
                        + repStr(".", dots + 1));
                dots += 3;
            }
        }
    }
}