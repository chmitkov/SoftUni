import java.util.Scanner;

public class ExamMarch2016_1 {
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        
        Double width = Double.parseDouble(scanner.nextLine());
        Double length = Double.parseDouble(scanner.nextLine());
        
        int deskRows = (int) ((width * 100) / 120);
        int deskNumber = (int) (((length * 100) - 100) / 70);
        int allDeskPlace = (deskRows * deskNumber) - 3;
        
        System.out.println(allDeskPlace);

    }
}
