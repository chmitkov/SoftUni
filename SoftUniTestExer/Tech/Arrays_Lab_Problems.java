Lab: Arrays
==========================================================
1.	Day of Week
==========================================================
import java.util.Arrays;
import java.util.Scanner;

public class Test_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] days = {"Monday", "Tuesday",
                "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
        try {
            System.out.println(days[Integer.parseInt(sc.nextLine()) - 1]);
        } catch (Exception e) {
            System.out.println("Invalid Day!");
        }
    }
}
=============================================================
2.	Print Numbers in Reverse Order
=============================================================
import java.util.Arrays;
import java.util.Scanner;

public class Test_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

       int n = Integer.parseInt(sc.nextLine());

       int[] numbers = new int[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(sc.nextLine());
        }
        for (int i = numbers.length-1; i >=0 ; i--) {
            System.out.println(numbers[i]);
        }
    }
}
==============================================================
3.	Sum Even Numbers
===============================================================
import java.util.Arrays;
import java.util.Scanner;

public class Test_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] numbers = Arrays.stream(sc.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        int result = 0;
        for (int currentNum : numbers) {
            if (currentNum % 2 == 0) {
                result += currentNum;
            }
        }
        System.out.println(result);
    }
}
===============================================================
4.	Reverse an Array of Strings
===============================================================
import java.util.Arrays;
import java.util.Scanner;

public class Test_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] array = sc.nextLine().split("\\s+");
        for (int i = 0; i < array.length / 2; i++) {
            swapElements(array, i);
        }
        System.out.println(String.join(" ", array));
    }
    private static void swapElements(String[] array, int firstIndex) {
        int secondIndex = array.length-1-firstIndex;
        String tempElement = array[firstIndex];
        array[firstIndex] = array[secondIndex];
        array[secondIndex] = tempElement;
    }
}
==================================================================
5.	Even and Odd Subtraction
==================================================================
import java.util.Arrays;
import java.util.Scanner;

public class Test_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] nums = Arrays.stream(sc.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        int even = 0;
        int odd = 0;
        for (int currentNum : nums) {
            if (currentNum % 2 == 0) {
                even+=currentNum;
            }else{
                odd+=currentNum;
            }
        }
        System.out.println(even-odd);
    }
}
======================================================================
6.	Equal Arrays
======================================================================
import java.util.Arrays;
import java.util.Scanner;

public class Test_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] numbers1 = Arrays.stream(sc.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        int[] numbers2 = Arrays.stream(sc.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        int maxLength = Math.max(numbers1.length, numbers2.length);
        int sum = 0;
        for (int i = 0; i < maxLength; i++) {
            sum+=numbers1[i];
            if (numbers1[i] != numbers2[i]) {
                System.out.printf("Arrays are not identical. " +
                        "Found difference at %d index", i);
                return;
            }
        }
        System.out.printf("Arrays are identical. Sum: %d",sum);
    }
}
=======================================================================
7.	Condense Array to Number
=======================================================================
import java.util.Arrays;
import java.util.Scanner;

public class Test_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] array = Arrays.stream(sc.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        while (array.length > 1) {
            int[] condensedArray = new int[array.length - 1];
            for (int i = 0; i < condensedArray.length; i++) {
                condensedArray[i] = array[i] + array[i + 1];
            }
            array = condensedArray;
        }
        System.out.println(array[0]);
    }
}
=========================================================================
