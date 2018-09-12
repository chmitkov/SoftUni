package classBox;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Box currBox = new Box();

        currBox.setLength(Double.parseDouble(br.readLine()));
        currBox.setWidth(Double.parseDouble(br.readLine()));
        currBox.setHeight(Double.parseDouble(br.readLine()));

        System.out.println(currBox.toString());

    }

}
