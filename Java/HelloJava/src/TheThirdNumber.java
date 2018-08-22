public class TheThirdNumber {
    //Напишете израз, който да проверява дали дадено
    // цяло число съдържа 7 за трета цифра (отдясно на ляво)
    public static void main(String[] arguments){
        int number = 1024;
        int num2 = (number/100)%10;
             System.out.println((num2 == 7) ? ("Yes") : ("No"));
    }
}
