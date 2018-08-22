import java.util.Scanner;
public class Exam2017December17_1IvanovisFamily {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        double money = Double.parseDouble(scanner.nextLine()),
                ch1price = Double.parseDouble(scanner.nextLine()),
                ch2price = Double.parseDouble(scanner.nextLine()),
                ch3price = Double.parseDouble(scanner.nextLine());

        double
               moneyForPres = ch1price+ch2price+ch3price;
                money -= moneyForPres;
                money -=money*0.1;

        System.out.printf("%.2f", money);
    }
}