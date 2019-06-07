import java.util.Scanner;

public class FriendlyTrip {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        int distanceInKm = Integer.parseInt(scanner.nextLine()),
                carCost= Integer.parseInt(scanner.nextLine());
        double fuelPrice = Double.parseDouble(scanner.nextLine());
        int friendsCash = Integer.parseInt(scanner.nextLine());
        double carCostPerKm= (carCost*fuelPrice)*1.0/100.0,
                distanceForMoneyInKm = friendsCash*1.0/carCostPerKm,
                moneyLeft = friendsCash - (distanceInKm*carCostPerKm),
                moneyPerF = (moneyLeft/5.0);

        if (distanceForMoneyInKm>=distanceInKm){
            System.out.printf("You can take a trip. %.02f money left.", moneyLeft);
        }else{
            System.out.printf("Sorry, you cannot take a trip. Each will receive %.02f money.", moneyPerF);
        }


    }
}
