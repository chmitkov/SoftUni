import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class ExersizeFromBook7 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int row = Integer.parseInt(br.readLine());
        int cow = Integer.parseInt(br.readLine());

        int [][] matrix = new int[row][cow];
        int counter=1;
        for (int i = 0; i < cow; i++) {
            for (int j = 0; j < row; j++) {
                matrix[j][i] =counter ;
                counter++;
            }
        }
        System.out.println(Arrays.deepToString(matrix));
    }
}
