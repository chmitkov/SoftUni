public class IsAinCircle {
    // Напишете програма, която проверява дали дадена
    // точка О (x, y) е вътре в окръжността К ((0,0), 5.
    public static void main(String[] arguments) {
        int x = 2, y = 3;
        System.out.println(((x * x + y * y) < 25) ?("Yes, it in"):("No"));
    }
}
