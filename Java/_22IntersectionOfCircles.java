import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;

public class _22IntersectionOfCircles {
    public static  void main(String [] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int [] c1 = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int c1x = c1[0];
        int c1y = c1[1];
        int c1r = c1[2];
        int [] c2 = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int c2x= c2[0];
        int c2y= c2[1];
        int c2r= c2[2];

        double distanceBetweenTwoPoints = Math.sqrt(Math.pow(c2x-c1x,2)+(c2y-c1y));

        System.out.println(distanceBetweenTwoPoints<=c1r+c2r
                ?"Yes"
                :"No");
    }
}
