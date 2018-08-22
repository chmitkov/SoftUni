import java.util.Scanner;

public class CardsForPlay {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
            for (int i=1; i<=4; i++){
                if (i== 1){
                    System.out.print("Diamonds ");
                    for (int j = 2; j <11;j++){
                        System.out.print("  Diamonds"+j);
                    }
                    for (int k = 0; k < 4; k++){
                        if (k==0){
                            System.out.print(" DiamondsJ" );
                        }else if (k==1){
                            System.out.print(" DiamondsQ");
                        }else if (k==2){
                            System.out.print(" DiamondsK");
                        }else if (k==3){
                            System.out.print(" DiomondsA");
                        }
                    }
                }else if (i==2) {
                    System.out.print("\nSpade ");
                    for (int j = 2; j <11;j++){
                        System.out.print("  Spade"+j);
                    }
                    for (int k = 0; k < 4; k++){
                        if (k==0){
                            System.out.print(" SpadeJ" );
                        }else if (k==1){
                            System.out.print(" SpadeQ");
                        }else if (k==2){
                            System.out.print(" SpadeK");
                        }else if (k==3){
                            System.out.print(" SpadeA");
                        }
                    }
                }else if (i == 3){
                    System.out.print("\nClubs ");
                    for (int j = 2; j <11;j++){
                        System.out.print("  Clubs"+j);
                    }
                    for (int k = 0; k < 4; k++){
                        if (k==0){
                            System.out.print(" ClubsJ" );
                        }else if (k==1){
                            System.out.print(" ClubsQ");
                        }else if (k==2){
                            System.out.print(" ClubsK");
                        }else if (k==3){
                            System.out.print(" ClubsA");
                        }
                    }
                }else if (i == 4){
                    System.out.print("\nHearts ");
                    for (int j = 2; j <11;j++){
                        System.out.print("  Hearts"+j);
                    }
                    for (int k = 0; k < 4; k++){
                        if (k==0){
                            System.out.print(" HeartsJ" );
                        }else if (k==1){
                            System.out.print(" HeartsQ");
                        }else if (k==2){
                            System.out.print(" HeartsK");
                        }else if (k==3){
                            System.out.print(" HeartsA");
                        }
                    }
                }

            }

    }
}
