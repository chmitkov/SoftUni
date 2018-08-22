import java.util.Scanner;

public class ThreeBrothersExam2017 {
    public static void main(String[] arguments){
        Scanner scanner = new Scanner(System.in);

        double b1Time = Double.parseDouble(scanner.nextLine()),
                b2Time = Double.parseDouble(scanner.nextLine()),
                b3Time = Double.parseDouble(scanner.nextLine()),
                fishTime = Double.parseDouble(scanner.nextLine());
        double workTime = (1/((1/b1Time)+(1/b2Time)+(1/b3Time))) + (1/((1/b1Time)+(1/b2Time)+(1/b3Time))*(15*0.01)),
                timeLeft = Math.floor(fishTime - workTime),
                timeNeed = Math.ceil(workTime - fishTime);

        if (workTime < fishTime) {
            System.out.printf("Cleaning time: %.2f \n" +
                    "Yes, there is a surprise - time left -> %.0f hours.", workTime, timeLeft );
        }else {
            System.out.printf("Cleaning time: %.2f \n" +
                    "No, there isn't a surprise - shortage of time -> %.0f hours.", workTime, timeNeed );
        }
    }
}
