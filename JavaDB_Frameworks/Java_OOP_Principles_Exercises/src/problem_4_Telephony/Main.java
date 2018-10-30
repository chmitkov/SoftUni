package problem_4_Telephony;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        ArrayList<String>numbers =
                new ArrayList<>(Arrays.asList(br.readLine().split(" ")));

        ArrayList<String>sites =
                new ArrayList<>(Arrays.asList(br.readLine().split(" ")));

        Smartphone smartphone = new Smartphone(numbers,sites);

        System.out.println(smartphone.callTo());
        System.out.println(smartphone.browseIn());
    }
}
