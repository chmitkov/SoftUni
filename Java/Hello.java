import java.util.Scanner;

public class Hello {
    public static void main(String[] arguments){
        Scanner scanner = new Scanner (System.in);
        String name = scanner.nextLine();
        System.out.printf("Hello, %s!", name);
    }
}
