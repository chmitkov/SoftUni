import java.util.Scanner;

public class _01ReadInput {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        String firstWord = scanner.next("\\w+");
        String secondWord = scanner.next("\\w+");

        int firstInt= scanner.nextInt();
        int secondInt= scanner.nextInt();
        int thirdInt= scanner.nextInt();

        scanner.nextLine();

        String thirdWord = scanner.nextLine();

        int sum = firstInt+secondInt+thirdInt;

        System.out.printf("%s %s %s %d", firstWord,secondWord,thirdWord,sum);

    }
}
