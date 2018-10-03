import java.util.Scanner;

public class _10MultiplyEvensByOdds {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberInString = Integer.parseInt(scanner.nextLine());

        System.out.println(getMultipleOfEvensAndOdds(numberInString));

    }

    private static int getMultipleOfEvensAndOdds(int number) {
        int evenDigit = 0;
        int oddDigit = 0;
        number = Math.abs(number);
        while (number>0){
            int currentNum = number%10;
            if (currentNum%2==0){
                evenDigit+=currentNum;
            }else{
                oddDigit+=currentNum;
            }
            number/=10;
        }
        return evenDigit * oddDigit;
    }
}
