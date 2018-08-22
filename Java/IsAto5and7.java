public class IsAto5and7 {
    //Напишете булев израз, който да проверява дали дадено цяло число се дели на 5 и на 7 без остатък.
    public static void main(String[] arguments ){
        int a = 10;
        if ((a%5==0)&&(a%7==0)) {
            System.out.println("Yes");
        }
        else {
            System.out.println("No");
        }

    }
}
