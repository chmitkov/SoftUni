import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.function.Predicate;

public class _3CountUppercaseWords {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<String> set = new ArrayList<>();
        String[] words = br.readLine().split(" ");
        Predicate<String> isFirstCharIsUpper = str -> str.charAt(0) == str.toUpperCase().charAt(0);
        for (String word : words) {
            if (isFirstCharIsUpper.test(word)) {
                set.add(word);
            }
        }
        System.out.println(set.size());
        set.forEach(System.out::println);
    }
}
