import java.util.Scanner;

public class _08Lottery {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        for (int i = 1; i <=8 ; i++) {
            for (int j = i+1; j <=9 ; j++) {
                for (int k = j+1; k <=10 ; k++) {
                    System.out.printf("%d %d %d%n",i,j,k);
                }
            }
        }
    }
}
