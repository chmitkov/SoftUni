import java.util.Scanner;

public class Exam2018January07_2FriendlyTrip {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int distance = Integer.parseInt(scanner.nextLine()),
                carNeedPerKm = Integer.parseInt(scanner.nextLine());
        double priceForLiter = Double.parseDouble(scanner.nextLine());
        int money = Integer.parseInt(scanner.nextLine());
        double  costPerKm = (carNeedPerKm*priceForLiter)/100,
                distanceNeedMoney = distance*costPerKm,
                moneyLeft = money - distanceNeedMoney,
                moneyForEveryone = money*1.0/5.0;
        if (money>=distanceNeedMoney){
            System.out.printf("You can take a trip. %.2f money left.", moneyLeft);
        }else {
            System.out.printf("Sorry, you cannot take a trip. Each will receive %.2f money.",moneyForEveryone);
        }


    }
}
