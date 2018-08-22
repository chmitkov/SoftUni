import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;

public class _06CompareCharArrays {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

         String arr11 = br.readLine().replace(" ","");
        String  arr22 = br.readLine().replace(" ","");
        char[] arr1 = arr11.toCharArray();
        char[] arr2 = arr22.toCharArray();

        for (int i = 0; i < Math.min(arr1.length, arr2.length); i++) {
            if (arr1[i] < arr2[i]) {
                Arrays.asList(arr1).forEach(System.out::println);
                Arrays.asList(arr2).forEach(System.out::println);
                return;
            } else if (arr1[i] > arr2[i]) {
                Arrays.asList(arr2).forEach(System.out::println);
                Arrays.asList(arr1).forEach(System.out::println);
                return;
            }
            if (i == Math.min(arr1.length, arr2.length) - 1) {
                if (arr1.length < arr2.length) {
                    Arrays.asList(arr1).forEach(System.out::println);
                    Arrays.asList(arr2).forEach(System.out::println);
                    return;
                } else if (arr1.length > arr2.length) {
                    Arrays.asList(arr2).forEach(System.out::println);
                    Arrays.asList(arr1).forEach(System.out::println);
                    return;
                }
            }
        }
        Arrays.asList(arr1).forEach(System.out::println);
        Arrays.asList(arr2).forEach(System.out::println);
    }
}
