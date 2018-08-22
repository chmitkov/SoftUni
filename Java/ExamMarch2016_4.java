import java.util.Scanner;

public class ExamMarch2016_4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num = Integer.parseInt(scanner.nextLine());

        int p1= 0,
                p2 =0,
                p3 =0,
                p4 =0,
                p5 =0;
       /* double p1percent = 0;
                p2percent = (p2*1.0/num)*100,
                p3percent = (p3*1.0/num)*100,
                p4percent = (p4*1.0/num)*100,
                p5percent = (p5*1.0/num)*100;*/


        for (int i = 0; i < num; i++ ){
            int num2 = Integer.parseInt(scanner.nextLine());
            if (num2 < 200){
                p1+=1;
            }else if (num2 < 400){
                p2+=1;
            }else if (num2 < 600){
                p3+=1;
            }else if (num2 < 800){
                p4+=1;
            }else {
                p5+=1;
            }
            double p1percent = (p1*1.0/num)*100,
                    p2percent = (p2*1.0/num)*100,
                    p3percent = (p3*1.0/num)*100,
                    p4percent = (p4*1.0/num)*100,
                    p5percent = (p5*1.0/num)*100;

        }

        System.out.printf("%.02f%%%n",((p1*1.0/num)*100) );
        System.out.printf("%.02f%%%n",((p2*1.0/num)*100) );
        System.out.printf("%.02f%%%n",((p3*1.0/num)*100) );
        System.out.printf("%.02f%%%n",((p4*1.0/num)*100) );
        System.out.printf("%.02f%%%n",((p5*1.0/num)*100) );

    }
}
