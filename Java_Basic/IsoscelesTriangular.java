public class IsoscelesTriangular{
    public static void main(String[] argumnets){
        int side = 5;
        for (int i = 1; i <= side; i++) {
            for (int j = 1; j<=i; j++){
                System.out.print("*");
            }
            System.out.println("");
        }
        for (int g = side - 2; g >=0; g--){
            for (int t = g; t>=0; t--){
                System.out.print("*");
            }
            System.out.println("");
        }
    }
}
