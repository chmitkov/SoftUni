import java.util.Scanner;

class ThreeNumFromConsole{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = Integer.parseInt(scanner.nextLine()),
                b = Integer.parseInt(scanner.nextLine()),
                c = Integer.parseInt(scanner.nextLine());
        System.out.print(a + "\n" + b +"\n" +c);
    }
}