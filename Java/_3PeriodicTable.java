import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Set;
import java.util.TreeSet;

public class _3PeriodicTable {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Set<String> set = new TreeSet<>();
            int counter = Integer.parseInt(br.readLine());

            while (counter-->0){
                String [] commands = br.readLine().split(" ");
                Collections.addAll(set,commands);
            }
            set.forEach(x-> System.out.printf("%s ",x));
    }
}
