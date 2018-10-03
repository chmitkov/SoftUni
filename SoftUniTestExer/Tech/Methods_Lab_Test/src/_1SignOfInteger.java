import java.util.Scanner;

public class _1SignOfInteger {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        printSign(Integer.parseInt(sc.nextLine()));
    }

    private static void printSign(int number) {
        if (number > 0)
            System.out.printf("The number %d is positive.", number);
        else if (number < 0)
            System.out.printf("The number %d is negative.", number);
        else
            System.out.printf("The number %d is zero.", number);
    }

}
