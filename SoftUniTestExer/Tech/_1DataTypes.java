import java.util.Scanner;

import static jdk.nashorn.internal.runtime.JSType.isString;

public class _1DataTypes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String type = scanner.nextLine();
        String line = scanner.nextLine();

        switch (type){
            case "int":
                isItInt(line);
                break;
            case "real":
                isDouble(line);
                break;
            case "string":
                isItString(line);
                break;
        }

    }

    private static void isItInt(String line) {
        System.out.println(Integer.parseInt(line)*2);
    }

    private static void isItString(String line) {
        System.out.printf("$%s$",line);
    }

    private static void isDouble(String line) {
        System.out.printf("%.2f",Double.parseDouble(line)*1.5);
    }
}
