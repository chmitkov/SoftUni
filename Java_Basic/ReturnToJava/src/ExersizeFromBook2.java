import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class ExersizeFromBook2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] nums1 = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
        int[] nums2 = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();

        if (nums1.length > nums2.length)
        {
            System.out.println("Nums1 is bigger");
        }else if (nums2.length>nums1.length)
        {
            System.out.println("Nums2 is bigger");
        }else
        {
            for (int i = 0; i < Math.min(nums1.length,nums2.length); i++) {
                if (nums1[i]!=nums2[i])
                {
                    System.out.println(nums1[i]>nums2[i]
                    ?"Nums1 is bigger"
                    :"Nums2 is bigger"
                    );
                    return;
                }
            }
        }

    }
}

