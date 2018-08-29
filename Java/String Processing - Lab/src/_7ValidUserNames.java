import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class _7ValidUserNames {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line = br.readLine();
        List<String> list = new ArrayList<>();
        Pattern regex = Pattern.compile("^[a-zA-Z0-9_\\-]{3,16}$");
        while (!"END".equals(line)) {
            Matcher matcher = regex.matcher(line);
            if(matcher.find()){
                list.add("valid");
            }else {
                list.add("invalid");
            }
            line = br.readLine();
        }
        if(list.contains("valid")){
            list.forEach(System.out::println);
        }
    }
}
