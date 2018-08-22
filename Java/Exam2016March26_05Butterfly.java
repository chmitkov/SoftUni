import java.util.Scanner;

public class Exam2016March26_05Butterfly {
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

        for (int i = 0; i < n - 2; i++) {
            if (i % 2 == 0) {
                System.out.println(repStr("*", n - 2) + "\\ /" + repStr("*", n - 2));
            } else {
                System.out.println(repStr("-", n - 2) + "\\ /" + repStr("-", n - 2));
            }
        }
        System.out.println(repStr(" ", n - 1) + "@" + repStr(" ", n - 1));
        for (int i = 0; i < n - 2; i++) {
            if (i % 2 == 0) {
                System.out.println(repStr("*", n - 2) + "/ \\" + repStr("*", n - 2));
            } else {
                System.out.println(repStr("-", n - 2) + "/ \\" + repStr("-", n - 2));
            }
        }
    }
}