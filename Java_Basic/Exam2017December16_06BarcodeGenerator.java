import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exam2017December16_06BarcodeGenerator {
    public static void main(String[] args) throws IOException {
        BufferedReader b = new BufferedReader(
                new InputStreamReader(System.in));

        int number1 = Integer.parseInt(b.readLine()),
                num1 = number1 / 1000;
        if (num1 % 2 != 0) {
            num1 -= 1;
        }
        int num2 = (number1 / 100) % 10;
        if (num2 % 2 != 0) {
            num2 -= 1;
        }
        int num3 = (number1 / 10) % 10;
        if (num3 % 2 != 0) {
            num3 -= 1;
        }
        int num4 = number1 % 10;
        if (num4 % 2 != 0) {
            num4 -= 1;
        }
        int number2 = Integer.parseInt(b.readLine()),
                num5 = number2 / 1000;
        if (num5 % 2 != 0) {
            num5 += 1;
        }
        int num6 = (number2 / 100) % 10;
        if (num6 % 2 != 0) {
            num6 += 1;
        }
        int num7 = (number2 / 10) % 10;
        if (num7 % 2 != 0) {
            num7 += 1;
        }
        int num8 = number2 % 10;
        if (num8 % 2 != 0) {
            num8 += 1;
        }
        for (int i = num1 + 1; i < num5; i += 2) {
            for (int j = num2 + 1; j < num6; j += 2) {
                for (int k = num3 + 1; k < num7; k += 2) {
                    for (int o = num4 + 1; o < num8; o += 2) {
                        System.out.printf("%d%d%d%d ", i, j, k, o);
                    }
                }
            }
        }

    }
}