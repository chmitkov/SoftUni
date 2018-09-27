Integer Operations
========================================================

import java.util.Scanner;

public class test1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num1 = Integer.parseInt(scanner.nextLine());
        int num2 = Integer.parseInt(scanner.nextLine());
        int num3 = Integer.parseInt(scanner.nextLine());
        int num4 = Integer.parseInt(scanner.nextLine());

        int result = ((num1 + num2) / num3) * num4;

        System.out.println(result);
    }
}

==========================================================

Exact Sum of Real Numbers

- работи вярно, но таблицата с Examples стои изместена на дясно и не се вижда добре 
изхода на пример 2 
==========================================================
import java.math.BigDecimal;
import java.util.Scanner;

public class test1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numbersCount = Integer.parseInt(scanner.nextLine());
        
	BigDecimal result = new BigDecimal("0");
       
	 while (numbersCount-->0){
            BigDecimal currentNum = new BigDecimal(scanner.nextLine());
            result = result.add(currentNum);
        }
       
	 System.out.println(result);
    }
}


==========================================================


Elevator
==========================================================

import java.util.Scanner;

public class test1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int personsCount = Integer.parseInt(scanner.nextLine());

        int capacity = Integer.parseInt(scanner.nextLine());

        int courses = (int) Math.ceil((double)personsCount/capacity);

        System.out.println(courses);
    }
}

=============================================================

Centuries to Minutes

- ИМА ГРЕШКА в скрийн шота(Solution) при печатането в printf, липсва %days
=============================================================

import java.util.Scanner;

public class test1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int centuries = Integer.parseInt(scanner.nextLine());
        int years = centuries * 100;
        int days = (int) (years * 365.2422);
        int hours = days * 24;
        int minutes = hours * 60;

        System.out.printf("%d centuries = %d years = %d days = %d hours = %d minutes"
                , centuries, years, days, hours, minutes);

    }
}

===============================================================

Special Numbers
===============================================================
import java.util.Scanner;

public class test1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= number; i++) {
            System.out.printf("%d -> %s%n", i, isMagic(i + "") ? "True" : "False");
        }

    }

    private static boolean isMagic(String number) {
        int sum = 0;
        for (int i = 0; i < number.length(); i++) {
            sum += Integer.parseInt(number.charAt(i) + "");
        }
        return (sum == 5 || sum == 7 || sum == 11);
    }
}

================================================================

Triples of Latin Letters
================================================================
import java.util.Scanner;

public class test1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < number; i++) {
            for (int j = 0; j < number; j++) {
                for (int k = 0; k < number; k++) {
                    char firstChar = (char) ('a' + i);
                    char secondChar = (char) ('a' + j);
                    char thirdChar = (char) ('a' + k);

                    System.out.printf("%c%c%c%n", firstChar, secondChar, thirdChar);
                }
            }
        }
    }
}
=================================================================

Concat Names
=================================================================
import java.util.Scanner;

public class test1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

       String firstName = scanner.nextLine();
       String secondName = scanner.nextLine();
       String delimiter = scanner.nextLine();

        System.out.printf("%s%s%s", firstName,delimiter,secondName);

    }
}
===================================================================

Refactor Volume of Pyramid - задача за рефакториране -> работи.
===================================================================

Refactor Special Numbers
- печата true/false с малки букви, а в примера е дадено True/False
==============================================================

