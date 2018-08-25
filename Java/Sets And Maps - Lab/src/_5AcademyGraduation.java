import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class _5AcademyGraduation {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Double> dict = new TreeMap<>();
        int counter = Integer.parseInt(br.readLine());
        DecimalFormat format = new DecimalFormat("0.################################");

        while (counter-- > 0) {
            String name = br.readLine();

            double[] marks = Arrays.stream(br.readLine().split(" "))
                    .mapToDouble(Double::parseDouble)
                    .toArray();
            double average = averageGrade(marks);

            dict.put(name, average);

        }
        dict.entrySet()
                .forEach(kvp ->
                        System.out.printf("%s is graduated with %s%n", kvp.getKey(),
                                format.format(kvp.getValue())));
    }

    private static double averageGrade(double[] marks) {
        double average = 0d;
        for (double num : marks) {
            average += num;
        }
        int arraySize = marks.length;
        average/=arraySize;
        return average;
    }

}
