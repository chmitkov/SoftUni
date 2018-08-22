import java.util.Scanner;

public class ClassAnimal {
    public static void main (String[] args){
        Scanner scanner = new Scanner (System.in);

        String name = scanner.nextLine(),
                result = "";

        switch (name){
            case "dog":
                result = "mammal";
                break;
            case "crocodile":
                result = "reptile";
                break;
            case "tortoise":
                result = "reptile";
                break;
            case "snake":
                result = "reptile";
                break;
                default:
                    result = "unknown";

        }
        System.out.println(result);
    }
}
