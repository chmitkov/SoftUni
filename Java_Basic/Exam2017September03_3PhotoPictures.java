import java.util.Scanner;

public class Exam2017September03_3PhotoPictures {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int photos = Integer.parseInt(scanner.nextLine());
        String type = scanner.nextLine().toLowerCase(),
                order = scanner.nextLine().toLowerCase();
        double total = 0.0;
        switch (type) {
            case "9x13":
                if (photos >= 50) {
                    total = (photos * 0.16) - ((photos * 0.16) * 0.05);
                } else {
                    total = photos * 0.16;
                }
                break;
            case "10x15":
                if (photos >= 80) {
                    total = (photos * 0.16) - ((photos * 0.16) * 0.03);
                } else {
                    total = photos * 0.16;
                }
                break;
            case "13x18":
                if (photos<50){
                    total = photos*0.38;
                }else {
                    if (photos>100){
                        total = (photos*0.38)-((photos*0.38)*0.05);
                    }else {
                        total = (photos*0.38)-((photos*0.38)*-0.03);
                    }
                }
                break;
            case "20x30":
                if (photos<10){
                    total = photos*2.9;
                }else {
                    if (photos>50){
                        total = (photos*2.9)-((photos*2.9)*0.09);
                    }else {
                        total = (photos*2.9)-((photos*2.9)*0.07);
                    }
                }
                break;
        }

        if ("online".equals(order)) {
            total = total - (total * 0.02);
        }

        System.out.printf("%.2fBGN", total);
    }
}