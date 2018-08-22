import java.util.Scanner;

public class RectangleS {
    public static void main(String[] arguments){
        Scanner scanner = new Scanner(System.in);
        int a = Integer.parseInt(scanner.nextLine());
        int b = Integer.parseInt(scanner.nextLine());

        int S = a*b;
        System.out.println(S);
    }
}
