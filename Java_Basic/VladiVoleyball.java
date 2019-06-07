import java.util.Scanner;

public class VladiVoleyball {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);

        String year = scanner.nextLine().toLowerCase();
        int p = Integer.parseInt(scanner.nextLine()),
                h = Integer.parseInt(scanner.nextLine());

        double playInSofia = (48-h)*(3.0/4),
                playInHomeCity = h*1.0,
                playInHolydays = p*(2.0/3),
                allGames = playInSofia+playInHomeCity+playInHolydays,
                allGamesLeap = allGames+(allGames * 0.15);

        switch (year){
            case "leap":
                System.out.printf("%.0f", Math.floor(allGamesLeap));
                break;
            case "normal":
                System.out.printf("%.0f",Math.floor(allGames));
                break;
            default:
                System.out.println("Error");
        }
    }
}
