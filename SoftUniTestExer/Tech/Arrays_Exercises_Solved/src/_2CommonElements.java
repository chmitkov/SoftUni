import java.util.Arrays;
import java.util.Scanner;

public class _2CommonElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String [] firstArray = scanner.nextLine().split(" ");
        String [] secondArray = scanner.nextLine().split(" ");

        for(String current : secondArray){
            if (Arrays.asList(firstArray).contains(current)){
                System.out.printf("%s ", current);
            }
        }
    }
}
