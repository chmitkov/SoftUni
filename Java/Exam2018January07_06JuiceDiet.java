import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exam2018January07_06JuiceDiet {
    public static void main(String[] args) throws IOException {
        BufferedReader b = new BufferedReader(new InputStreamReader(System.in));
       int rasp = Integer.parseInt(b.readLine());
       int straw = Integer.parseInt(b.readLine());
       int cherr = Integer.parseInt(b.readLine());
       double juice = Double.parseDouble(b.readLine());
       //double newJ = 0.0;
        int newC=0,
                newR=0,
                newS=0;

        while(juice>1){
            while (juice>=15){
                juice-=15;
                cherr--;
                newC++;
            }
            if(juice>7.5){
                juice-=7.5;
                straw--;
                newS++;
            }
            if(juice>4.5){
                juice-=4.5;
                rasp--;
                newR++;
            }

        }
        System.out.printf("%d %d %d", newC,newS,newR);
     // for (int i = 0; i <=rasp; i++) {
     //     for (int j = 0; j <= straw; j++) {
     //         for (int k = 0; k <=cherr; k++) {
     //             // newJ = i * 4.5 + j * 7.5 + k * 4.5;
     //             if (i*4.5+j*7.5+k*15 <= juice && k>j &&k>i){
     //                 System.out.printf("%d%d%d ",i,j,k);

     //             }
     //         }
     //     }
      //  }
    }
}