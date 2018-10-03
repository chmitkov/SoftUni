import java.util.Scanner;

public class _9GreaterOfTwoValues {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String type = scanner.nextLine();

        switch (type) {
            case "int":
                int num1 = Integer.parseInt(scanner.nextLine());
                int num2 = Integer.parseInt(scanner.nextLine());
                System.out.println(getMax(num1, num2));
                break;
            case "char":
                char char1 = scanner.nextLine().charAt(0);
                char char2 = scanner.nextLine().charAt(0);
                System.out.println(getMax(char1, char2));
                break;
            case "String":
                String str1 = scanner.nextLine();
                String str2 = scanner.nextLine();
                System.out.println(getMax(str1, str2));
                break;
        }

    }

    private static int getMax(int num1, int num2) {
        return num1 > num2 ? num1 : num2;
    }

    private static char getMax(char num1, char num2) {
        return num1 > num2 ? num1 : num2;
    }

    private static String getMax(String str1, String str2) {
        return str1.compareTo(str2) > 0 ? str1 : str2;
    }
}
