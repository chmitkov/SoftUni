import java.util.Scanner;

public class Exam2017September03_4Cake {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int cakeW = Integer.parseInt(scanner.nextLine()),
                cakeL = Integer.parseInt(scanner.nextLine());
        int totalP = 0,
                totalE = 0;

        totalP = cakeW * cakeL;

        for (int i = 0; ; i++) {
            if (totalP < totalE) {
                break;
            }
            String pieces = scanner.nextLine();
            if ("STOP".equals(pieces)) {
                break;
            } else {
                totalE += Integer.parseInt(pieces);
            }
        }
        if (totalP >= totalE) {
            System.out.printf("%d pieces are left.", (totalP - totalE));
        } else {
            System.out.printf("No more cake left! You need %d pieces more.", (totalE - totalP));
        }

    }
}