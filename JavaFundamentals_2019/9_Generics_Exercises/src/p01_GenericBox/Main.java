package p01_GenericBox;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int counter = Integer.parseInt(br.readLine());

        while (counter-- > 0) {
            Box currentBox = new Box(br.readLine());
            System.out.println(currentBox);
        }
    }
}
