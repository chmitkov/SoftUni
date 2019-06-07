import java.math.BigDecimal;
import java.util.Scanner;

public class _03EuroTrip {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        double quantity  = Double.parseDouble(scanner.nextLine());
        BigDecimal sumInLeva = new BigDecimal(quantity*1.2);

        BigDecimal exchange = new BigDecimal("4210500000000");
        BigDecimal marksNeeded = exchange.multiply(sumInLeva);

        System.out.printf("%.2f marks", marksNeeded);
    }
}
