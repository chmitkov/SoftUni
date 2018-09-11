package catLady;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Cat> cats = new HashMap<>();
        String line = br.readLine();

        while (!"End".equals(line)) {
            String [] commands = line.split("\\s+");

            Cat currCat = new Cat(commands[0],commands[1],Double.parseDouble(commands[2]));

            cats.put(commands[1],currCat);

            line = br.readLine();
        }

        String searchedCatName = br.readLine();

        System.out.println(cats.get(searchedCatName).toString());
    }
}
