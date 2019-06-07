import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exam2018January07_04Salary {
    public static void main(String[] args) throws IOException {
        BufferedReader b = new BufferedReader(new InputStreamReader(System.in));

        double salary = Double.parseDouble(b.readLine());
        int years = Integer.parseInt(b.readLine());
        String sind = b.readLine();

        //  for (int i = 1; i <= years; i++) {
        //      salary += salary * 0.06;
        //      if (i % 10 == 0) {
        //          salary += 200;
        //      } else if (i % 5 == 0) {
        //          salary += 100;
        //      } else {
        //          if ("yes".equalsIgnoreCase(sind)) {
        //              salary -= salary * 0.01;
        //          }
        //      }
        //      if (salary >= 5000) {
        //          System.out.print("Current salary: 5000.00\n" +
        //                  "0 more years to max salary.\n");
        //          return;
        //      }
        //  }
        //  double salary1 = salary;
        //  int moreYears = 0;
        //  for (int i = years; ; i++) {
        //      salary1 += salary1 * 0.06;
        //      if (i % 10 == 0) {
        //          salary1 += 200;
        //      } else if (i % 5 == 0) {
        //          salary1 += 100;
        //      } else {
        //          if ("yes".equalsIgnoreCase(sind)) {
        //              salary1 -= salary1 * 0.01;
        //          }
        //      }
        //      if (salary1 >= 5000) {
        //          // System.out.print("Current salary: 5000.00\n" +
        //          //        "0 more years to max salary.\n");
        //          break;
        //      }
        //      moreYears++;

        //  }
        //  //while (salary1 <= 5000) {
        //  //    salary1 += salary1 * 0.06;
        //  //    if (moreYears + years % 10 == 0) {
        //  //        salary1 += 200;
        //  //    } else if (moreYears + years % 5 == 0) {
        //  //        salary1 += 100;
        //  //    } else {
        //  //        if ("yes".equalsIgnoreCase(sind)) {
        //  //            salary1 -= salary1 * 0.01;
        //  //        }
        //  //    }
        //  //    if (salary1 >= 5000) {
        //  //        //System.out.print("Current salary: 5000.00\n" +
        //  //        //        "0 more years to max salary.\n");
        //  //        break;
        //  //    }
        //  //    moreYears++;
        //  //}
        //  System.out.printf("Current salary: %.2f\n" +
        //          "%d more years to max salary.\n", salary, moreYears);
        for (int i = 1; ; i++) {
            salary = salary * 1.06;
            if (i % 5 == 0) {
                salary += 100;
            }
            if (i % 10 == 0) {
                salary += 100;
            }
            if ("yes".equalsIgnoreCase(sind) && (i % 5 != 0 || i % 10 != 0)) {
                salary *= 0.99;
            }
            if (i == years && salary < 5000) {
                System.out.printf("Current salary: %.2f\n", salary);
            } else if (salary >= 5000 && years >= i) {
                System.out.print("Current salary: 5000.00\n" +
                        "0 more years to max salary.");
                break;
            }
            if (salary >= 5000) {
                System.out.printf("%d more years to max salary.", (i - years - 1));
                break;
            }
        }
    }
}