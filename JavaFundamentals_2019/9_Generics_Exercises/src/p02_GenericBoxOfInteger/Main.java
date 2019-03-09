package p02_GenericBoxOfInteger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int counter = Integer.parseInt(br.readLine());

        while (counter-- > 0) {
            Box currentBox = new Box(Integer.valueOf(br.readLine()));
            System.out.println(currentBox);
        }
    }
}
