import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Days1000FromBirth {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int daysToAdd = 999;
        String birthDate = scanner.nextLine();

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");  //dd-MM-yyyy
        LocalDate outputDate = LocalDate.parse(birthDate, dtf);

        outputDate = outputDate.plusDays(daysToAdd);

        System.out.println(dtf.format(outputDate));
    }
}