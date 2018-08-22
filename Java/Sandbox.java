import java.util.Scanner;
public class Sandbox{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        double width = Double.parseDouble(scanner.nextLine()),
                length =Double.parseDouble(scanner.nextLine()),
                sandPrice = Double.parseDouble(scanner.nextLine()),
                boardPrice = Double.parseDouble(scanner.nextLine());

        double allS = width*length,
                sandS = (width-0.4)*(length-0.4),
                boardS = allS-sandS,
                sandNeed = Math.ceil(sandS*20),
                boardNeed = Math.ceil((boardS*1.0)/(2.2*0.2)),
                sandCost = sandNeed*sandPrice,
                boardCost = boardNeed*boardPrice,
                allCost = sandCost+boardCost;
        System.out.printf("%.2f",allCost);
    }
}
