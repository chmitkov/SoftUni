package animalFarm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {

            Chicken chicken = new Chicken(
                    br.readLine(),
                    Integer.parseInt(br.readLine())
            );

            System.out.println(chicken.toString());

        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }
    }

}
