import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class _03ReverseCharacters {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> array = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            String currStr = br.readLine();
            array.add(currStr);
        }
        for (int i = array.size()-1; i >=0 ; i--) {
            System.out.print(array.get(i));
        }
    }
}
