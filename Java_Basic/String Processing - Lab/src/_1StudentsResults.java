import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _1StudentsResults {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] commands = br.readLine().split("[\\-,]");

        String name = commands[0].trim();
        double jAdvScore = Double.parseDouble(commands[1].trim());
        double jOopScore = Double.parseDouble(commands[2].trim());
        double advOOPScore = Double.parseDouble(commands[3].trim());
        double average = (jAdvScore+jOopScore+advOOPScore)/3;

        System.out.println("Name      |   JAdv|JavaOOP| AdvOOP|Average|");
        System.out.printf("%1$-10s|%2$7.2f|%3$7.2f|%4$7.2f|%5$7.4f|"
                ,name,jAdvScore,jOopScore,advOOPScore,average);

    }
}
