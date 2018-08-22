import java.util.Scanner;

public class CubeFromStars2 {

        public static void main(String[] args) {


            Scanner scanner = new Scanner(System.in);
            int n = scanner.nextInt();

            for (int row = 1; row <= n; row++) {
                for (int col = 1; col <= n; col++) {
                    if (row == 1 || row == n) {
                        System.out.print("*");
                    } else {

                        if (col == 1 || col == n) {
                            System.out.print("*");
                        } else {
                            System.out.print(" ");
                        }
                    }
                }
                System.out.println();
            }
        }
    }


