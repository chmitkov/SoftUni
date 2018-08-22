import java.util.Scanner;

public class ExamApril2016_4SmartLili{
    public static void main(String[] args){
        Scanner scanner = new Scanner (System.in);

        int age = Integer.parseInt(scanner.nextLine());
        double washPrice = Double.parseDouble(scanner.nextLine());
        int toyPrice = Integer.parseInt(scanner.nextLine()),
                toy = 0;
        double money = 10.0;


        for (int i = 1; i <= age; i++){
            if (i % 2 != 0){
                toy+=1;
            }
            if (i % 2 == 0&&i != 2){
                money+=10;
            }
        }
        money-=age;
        money+=(toy*toyPrice);

        if (money>=washPrice){
            System.out.printf("Yes! %.2f", (money - washPrice));
        }else {
            System.out.printf("No! %.2f", (washPrice - money));
        }
    }
}