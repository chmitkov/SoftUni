import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class _6MagicExchangeableWords {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String [] words  = br.readLine().split(" ");

        Set<String> set1 = new HashSet<>();
        Set<String> set2 = new HashSet<>();
        Arrays.asList(words[0].toCharArray()).forEach(x->{
            String current = x+"";
            set1.add(current)
            ;});
        Arrays.asList(words[1].toCharArray()).forEach(x->{
            String current = x+"";
            set2.add(current)
            ;});

        if (set1.size() == set2.size()){
            System.out.println("true");
        }else{
            System.out.println("false");
        }
    }
}
