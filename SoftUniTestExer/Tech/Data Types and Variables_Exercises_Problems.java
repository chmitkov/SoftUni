Exercises: Data Types and Variables
=============================================================

Sum Digits
=============================================================
import java.util.Scanner;

public class test1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String num = scanner.nextLine();
        int sum = 0;
        for (int i = 0; i < num.length(); i++) {
            int currentDigit = Integer.parseInt(num.charAt(i)+"");
            sum+=currentDigit;
        }
        System.out.println(sum);
    }
}
==============================================================

Chars to String 
	- има правописна грешка "Write a program that reads 4 lines of input",
а линиите, които четем са 3(поне в примерите).
==============================================================
import java.util.Scanner;

public class test1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

       char firstChar = scanner.nextLine().charAt(0);
       char secondChar = scanner.nextLine().charAt(0);
       char thirdChar = scanner.nextLine().charAt(0);

        System.out.printf("%c%c%c",firstChar,secondChar,thirdChar);
    }
}
================================================================

Town Info
================================================================
import java.util.Scanner;

public class test1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String townName =  scanner.nextLine();
        long townPopulation = Long.parseLong(scanner.nextLine());
        int townArea = Integer.parseInt(scanner.nextLine());
        System.out.printf("Town %s has population of %d and area %d square km",
                townName,townPopulation,townArea);
    }
}
=================================================================

Convert Meters to Kilometres
=================================================================
import java.util.Scanner;

public class test1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int meters = Integer.parseInt(scanner.nextLine());
        double kilometers = meters / 1000.0;
        System.out.printf("%.2f", kilometers);
    }
}
==================================================================

Dollars to Pounds 
	- не е дадено на какъв курс да се смята задачата, като по 
този начин и невъзможно да бъде точна.
==================================================================

Reversed Chars
==================================================================
import java.util.Scanner;

public class test1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

       char firstChar = scanner.nextLine().charAt(0);
       char secondChar = scanner.nextLine().charAt(0);
       char thirdChar = scanner.nextLine().charAt(0);

        System.out.printf("%c %c %c",thirdChar,secondChar,firstChar);
    }
}
====================================================================

Lower or Upper
====================================================================
import java.util.Scanner;

public class test1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

       char currentChar = scanner.nextLine().charAt(0);

        System.out.print(Character.isLowerCase(currentChar)?
                "lower-case" : "upper-case");
    }
}
====================================================================

*Snowballs
====================================================================
import java.util.Scanner;

public class test1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfSnowballs = Integer.parseInt(scanner.nextLine());
        double bestValue = 0;
        String result = "";
        while (numberOfSnowballs-- > 0) {
            int snowballSnow = Integer.parseInt(scanner.nextLine());
            int snowballTime = Integer.parseInt(scanner.nextLine());
            int snowballQuality = Integer.parseInt(scanner.nextLine());

            double currentSnowballValue =
                    Math.pow((snowballSnow * 1.0 / snowballTime), snowballQuality);

            if (currentSnowballValue > bestValue) {
                bestValue = currentSnowballValue;
                result = String.format("%d : %d = %d (%d)",
                        snowballSnow, snowballTime, (int) currentSnowballValue, snowballQuality);
            }
        }
        System.out.println(result);
    }
}
======================================================================

*Poke Mon
======================================================================
import java.util.Scanner;

public class test1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int pokePower = Integer.parseInt(scanner.nextLine());
        int pokeOriginalValue = pokePower;
        int distance = Integer.parseInt(scanner.nextLine());
        int exhaustionFactor = Integer.parseInt(scanner.nextLine());
        int pokeCounter = 0;
        
        while (pokePower >= distance) {
            pokeCounter++;
            pokePower -= distance;
            if (pokePower == pokeOriginalValue / 2) {
                if (exhaustionFactor != 0 && pokePower != 0) {
                    pokePower /= exhaustionFactor;
                }
            }
        }
        System.out.println(pokePower);
        System.out.println(pokeCounter);
    }
}
========================================================================