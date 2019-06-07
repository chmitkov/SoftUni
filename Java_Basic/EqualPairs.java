import java.util.Scanner;

public class EqualPairs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numbers = Integer.parseInt(scanner.nextLine()),
                currentSum = 0,
                previousSum = 0,
                diff = 0,
                bigDiff = 0;


        for (int i = 0; i < numbers*2; i++) {
            int num1 = Integer.parseInt(scanner.nextLine());
            int num2 = Integer.parseInt(scanner.nextLine());
            if (i == 0){
                previousSum = num1+num2;
            }
                currentSum = num1 + num2;

                diff = Math.abs(previousSum-currentSum);
                if (diff>bigDiff){
                    bigDiff=diff;
                }
                currentSum = previousSum;
        }
        if (bigDiff == 0){
            System.out.printf("Yes, value = %d", previousSum);
        }else{
            System.out.printf("No, maxdiff = %d", bigDiff);
        }
    }
}
