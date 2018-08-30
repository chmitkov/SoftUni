import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class _5Palindromes {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Set<String> set = new TreeSet<>();

        String [] words = br.readLine().split("[,.!?\\s+]");
        for (String word : words) {
            if (!"".equals(word)){
                StringBuilder sb1 = new StringBuilder(word.trim());
                sb1.reverse();
                if (word.trim().equals(sb1.toString())||word.trim().length()==1){
                    set.add(word.trim());
                }
            }
        }
        System.out.println(set.toString());
    }

}
