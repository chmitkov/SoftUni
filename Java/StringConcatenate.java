import java.util.Scanner;

public class StringConcatenate {
    public static void main(String[] aruguments){
        Scanner scanner = new Scanner (System.in);

        String firstName = scanner.nextLine(),
                seconName = scanner.nextLine();
        int age = Integer.parseInt(scanner.nextLine());
        String  town = scanner.nextLine();

        System.out.printf("You are %s %s, a %d-years old person from %s.",
                firstName, seconName, age, town);

    }
}
