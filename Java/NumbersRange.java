import java.util.Scanner;

public class NumbersRange {
    public static void main(String[] arguments) {

        Scanner scanner = new Scanner(System.in);

        int num1 = Integer.parseInt(scanner.nextLine()),
                num2 = Integer.parseInt(scanner.nextLine()),
                dif = Math.abs(num1 - num2),
                minNum = Math.min(num1,num2),
                maxNum = Math.max(num1,num2);

        for(int i=minNum; i<maxNum; i++){
            if (i%5==0) {
                System.out.println(i);
            }
        }
    };

}
