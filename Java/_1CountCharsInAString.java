import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

public class _1CountCharsInAString {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Map<Character, Integer> map = new LinkedHashMap<>();
        String text = br.readLine();

        for (int i = 0; i < text.length(); i++) {
            if (!map.containsKey(text.charAt(i))) {
                map.put(text.charAt(i), 1);
            } else {
                map.put(text.charAt(i),
                        map.get(text.charAt(i)) + 1);
            }
        }
        map.entrySet().stream()
                .filter(x->!(x.getKey()+"").equals(" "))
                .forEach(x -> System.out.printf("%c -> %d%n",
                x.getKey(), x.getValue()));
    }
}
