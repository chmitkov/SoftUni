import java.util.Scanner;

public class Exam2017September03_2Scholarship {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double income = Double.parseDouble(scanner.nextLine());
        double marks = Double.parseDouble(scanner.nextLine());
        double minSalary = Double.parseDouble(scanner.nextLine()),
                socSchol = 0.0,
                schol = 0.0;

        if (income < minSalary) {
            if (marks >= 5.5) {
                socSchol = minSalary * 0.35;
                schol = marks * 25;
                if (socSchol > schol) {
                    System.out.printf("You get a Social scholarship %.0f BGN", Math.floor(socSchol));
                } else {
                    System.out.printf("You get a scholarship for excellent results %.0f BGN", Math.floor(schol));
                }
            } else if (marks > 4.5) {
                socSchol = minSalary * 0.35;
                System.out.printf("You get a Social scholarship %.0f BGN", Math.floor(socSchol));
            } else {
                System.out.println("You cannot get a scholarship!");
            }
        } else {
            if (marks >= 5.5) {
                schol = marks * 25;
                System.out.printf("You get a scholarship for excellent results %.0f BGN", Math.floor(schol));
            } else {
                System.out.println("You cannot get a scholarship!");
            }
        }
    }
}

