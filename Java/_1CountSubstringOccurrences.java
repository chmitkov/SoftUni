import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _1CountSubstringOccurrences {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int counter = 0;
        String text = br.readLine().toLowerCase();
        String searchedWord =  br.readLine().toLowerCase();
        while (text.contains(searchedWord)){
            counter++;
            text=text.substring(text.indexOf(searchedWord)+1);
        }
        System.out.println(counter);
    }
}
