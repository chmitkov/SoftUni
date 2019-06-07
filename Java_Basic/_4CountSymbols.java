import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class _4CountSymbols {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<Character,Integer> dict = new TreeMap<>();
        String input = br.readLine();

        for (int i = 0; i < input.length(); i++) {
            char current = input.charAt(i);

            if (!dict.containsKey(current)){
                dict.put(current,1);
            }else{
                dict.put(current,dict.get(current)+1);
            }
        }
        dict.entrySet()
                .forEach(kvp-> System.out.printf("%s: %d time/s%n",kvp.getKey(),kvp.getValue()));
    }
}
