import java.util.Scanner;

public class _4PasswordValidator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String isValid ="Password is valid";
        String password = scanner.nextLine();
        checkPass(password,isValid);
        System.out.println(isValid.isEmpty()?"":isValid);
    }

    private static void checkPass(String password, String isValid) {
        checkLength(password, isValid);
        checkChars(password, isValid);
        checkIsHaveTwoDigits(password,isValid);
    }

    private static void checkIsHaveTwoDigits(String password, String isValid) {
        int sumOfDigits = 0;
        for (int i = 0; i < password.length(); i++) {
            if (Character.isDigit(password.charAt(i))) {
                sumOfDigits++;
            }
            if (sumOfDigits > 1) {
                break;
            }
        }

        if (sumOfDigits < 2){
            System.out.println("Password must have at least 2 digits");
            isValid = "";
        }

    }

    private static void checkChars(String password,String isValid) {
        for (int i = 0; i < password.length(); i++) {
            char currentChar = password.charAt(i);
            if (!(Character.isDigit(currentChar) || Character.isAlphabetic(currentChar))) {
                System.out.println("Password must consist only of letters and digits");
                isValid = "";
                break;
            }
        }
    }

    private static void checkLength(String password,String isValid) {
        if (password.length() < 6 || password.length() > 10) {
            System.out.println("Password must be between 6 and 10 characters");
            isValid ="";
        }
    }
}
