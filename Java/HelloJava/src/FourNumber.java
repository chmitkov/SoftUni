public class FourNumber {
    // Напишете програма, която приема за вход четирицифрено
    // число във формат abcd и след това извършва
    // следните действия върху него:
    //-     Пресмята сбора от цифрите на числото.
    //-     Разпечатва на конзолата цифрите в обратен ред: dcba.
    //-     Поставя последната цифра, на първо място: dabc.
    //-     Разменя мястото на втората и третата цифра: acbd.
    public static void main(String[] arguments){
        int num = 1234,
                num4 =  num%10,
                num3 = (num/10)%10,
                num2 = (num/100)%10,
                num1 = (num/1000)%10,
                sum = num1 + num2 + num3 + num4;
        String rev = (""+num4)+(""+num3)+(""+num2)+(""+num1);
        String rev2 = (""+num4)+(""+num1)+(""+num2)+(""+num3);
        String rev3 = (""+num1)+(""+num3)+(""+num2)+(""+num4);

        System.out.println(sum);
        System.out.println(rev);
        System.out.println(rev2);
        System.out.println(rev3);

    }
}
