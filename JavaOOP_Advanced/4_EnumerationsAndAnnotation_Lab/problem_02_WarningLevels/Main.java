package problem_02_WarningLevels;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String neededImportance = br.readLine();

        Logger logger = new Logger();

        String line;

        while (!"END".endsWith(line=br.readLine())){
            String[] tokens = line.split(": ");

            logger.addMessage(neededImportance, tokens[0],tokens[1]);
        }

        logger.getMessages().forEach(System.out::println);
    }
}
