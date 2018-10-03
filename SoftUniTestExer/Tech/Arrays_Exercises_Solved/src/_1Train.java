import java.util.Arrays;
import java.util.Scanner;

public class _1Train {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int length = Integer.parseInt(scanner.nextLine());

        int [] array = new int[length];

        for (int i = 0; i < array.length; i++) {
            array[i] = Integer.parseInt(scanner.nextLine());
        }

        for(int currentNum : array){
            System.out.printf("%d ",currentNum);
        }

        System.out.printf("%n%d",Arrays.stream(array).sum());
    }
}
