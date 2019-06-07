import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.*;
import java.text.DateFormat;

public class _20CountWorkingDays {
    public static void main(String[] args) throws IOException, ParseException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] d1= Arrays.stream(br.readLine().split("-"))
                .mapToInt(Integer::parseInt)
                .toArray();
        int[] d2= Arrays.stream(br.readLine().split("-"))
                .mapToInt(Integer::parseInt)
                .toArray();

        LocalDate date1 = LocalDate.of(0,d1[1],d1[0]);
        LocalDate date2 = LocalDate.of(0,d2[1],d2[0]);


        LocalDate[] dates = new LocalDate[]{
                LocalDate.of(0,1,1),
                LocalDate.of(0,3,3),
                LocalDate.of(0,5,1),
                LocalDate.of(0,5,6),
                LocalDate.of(0,5,24),
                LocalDate.of(0,6,6),
                LocalDate.of(0,6,22),
                LocalDate.of(0,11,1),
                LocalDate.of(0,12,24),
                LocalDate.of(0,12,25),
                LocalDate.of(0,12,26),

        };

        int counter = 1;
        while (date1.isBefore(date2)){


                if(date1.getDayOfWeek()!= DayOfWeek.SATURDAY
                        &&date1.getDayOfWeek()!=DayOfWeek.SUNDAY
                        &&!Arrays.asList(dates).contains(date1)){
                    counter++;
                }

            date1 = date1.plusDays(1);
        }
       System.out.println(counter);
    }
}
