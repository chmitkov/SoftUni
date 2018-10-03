import java.util.Scanner;

public class _4Calculations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String command = scanner.nextLine();
        int firstNumber = Integer.parseInt(scanner.nextLine());
        int secondNumber = Integer.parseInt(scanner.nextLine());

        switch (command){
            case "add":
                addNum(firstNumber,secondNumber);
                break;
            case "divide":
                divideNum(firstNumber,secondNumber);
                break;
            case "subtract":
                subtract(firstNumber,secondNumber);
                break;
            case "multiply":
                multiply(firstNumber,secondNumber);
                break;
        }
    }
    private static void addNum (int num1, int num2){
        System.out.println(num1+num2);
    }
    private static void divideNum (int num1, int num2){
        System.out.println(num1/num2);
    }
    private static void subtract (int num1, int num2){
        System.out.println(num1-num2);
    }
    private static void multiply (int num1, int num2){
        System.out.println(num1*num2);
    }
}
