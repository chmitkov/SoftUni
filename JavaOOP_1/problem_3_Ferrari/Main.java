package problem_3_Ferrari;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.instrument.IllegalClassFormatException;

public class Main {
    public static void main(String[] args) throws IllegalClassFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String driver = br.readLine();

        Ferrari ferrari = new Ferrari(driver);

        System.out.println(ferrari);
    }
}
