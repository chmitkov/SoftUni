import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exam2016April24_03OperationsBetweenNumbers {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n1 = Integer.parseInt(br.readLine());
        int n2 = Integer.parseInt(br.readLine());
        String operator = br.readLine();
        String even = "";

        if ("+".equalsIgnoreCase(operator)) {
            if ((n1 + n2) % 2 == 0) {
                even = "even";
            } else {
                even = "odd";
            }
            System.out.printf("%d %s %d = %d - %s", n1, operator, n2, n1 + n2, even);
        } else if ("-".equalsIgnoreCase(operator)) {
            if ((n1 - n2) % 2 == 0) {
                even = "even";
            } else {
                even = "odd";
            }
            System.out.printf("%d %s %d = %d - %s", n1, operator, n2, n1 - n2, even);
        } else if ("*".equalsIgnoreCase(operator)) {
            if ((n1 * n2) % 2 == 0) {
                even = "even";
            } else {
                even = "odd";
            }
            System.out.printf("%d %s %d = %d - %s", n1, operator, n2, n1 * n2, even);
        } else if ("/".equalsIgnoreCase(operator)) {
            if (n2 == 0) {
                System.out.printf("Cannot divide %d by zero", n1);
                return;
            }
            System.out.printf("%d %s %d = %.2f", n1, operator, n2, n1 * 1.0 / n2);
        }else {
        System.out.printf("%d %s %d = %d", n1, operator, n2, n1 % n2);
    }
}}