import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class ExersizeFromBook5 {
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int [] nums = Arrays.stream(br.readLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();
        String result = Arrays.toString(nums).replaceAll(",","")
                .replaceAll("[,]","");
        System.out.println(result);


    }
}
