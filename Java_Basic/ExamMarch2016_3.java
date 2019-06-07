import java.util.Scanner;

public class ExamMarch2016_3 {

    public static void main(String[] arguments){
        Scanner scanner = new Scanner (System.in);
        int examH = Integer.parseInt(scanner.nextLine());
        int examM = Integer.parseInt(scanner.nextLine());
        double examT = examH*60 + examM;

        int studentH = Integer.parseInt(scanner.nextLine()),
                studentM = Integer.parseInt(scanner.nextLine()),
                studentT = studentH*60+studentM;
               double studentArrive = examT-studentT,
                  studentArriveH = (studentArrive/60);
        System.out.println(studentArriveH);

        if (studentArrive < 0){
            if (studentArrive < 60){
                System.out.printf("Late%n%02.0f mm minutes after the start",Math.abs(studentArrive));
            }else{
                System.out.printf("Late%f:%02f",studentArriveH,(studentArrive - studentArriveH*60));
            }
        }else if(studentArrive <= 30){
            if (studentArrive == 0){
            System.out.println("On time");
            }else {
                System.out.printf("%02.0f mm minutes after the start", studentArrive);
            }
        }else if(studentArrive > 30){
            if (studentArrive < 60){
                System.out.printf("Early%n%02f hours after the start",studentArrive);
            }else{
                System.out.printf("Early%n%f:%02f hours after the start",studentArriveH, (studentArrive - studentArriveH*60));
            }
        }
    }
}
