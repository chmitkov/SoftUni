import java.util.Scanner;

public class Exam2017July23_04EnergyLoss {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int days = Integer.parseInt(scanner.nextLine()),
                dancers = Integer.parseInt(scanner.nextLine());
        int p1 = 0, p2 = 0, p3 = 0, p4 = 0;
        for (int i = 1; i <= days; i++) {
            int hours = Integer.parseInt(scanner.nextLine());
            if (i % 2 == 0 && hours % 2 == 0) {
                p1 += 1;
            } else if (i % 2 != 0 && hours % 2 == 0) {
                p2 += 1;
            } else if (i % 2 == 0 && hours % 2 != 0) {
                p3 += 1;
            } else /*if (i % 2 != 0 && hours % 2 != 0)*/ {
                p4 += 1;
            }
        }
        int  total = p1 * (dancers * 68) + p2 * (dancers * 49)
                + p3 * (dancers * 65) + p4 * (dancers * 30),
                totalEnergy = 100 * days * dancers;
        totalEnergy = totalEnergy - total;
        double energyLeftPerDancer = (totalEnergy*1.0/ days)*1.0 / dancers;
        if (energyLeftPerDancer >= 50) {
            System.out.printf("They feel good! Energy left: %.2f", energyLeftPerDancer);
        } else {
            System.out.printf("They are wasted! Energy left: %.2f", energyLeftPerDancer);
        }
    }
}