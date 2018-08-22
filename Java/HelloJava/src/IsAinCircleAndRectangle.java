public class IsAinCircleAndRectangle {
    //Напишете програма, която проверява дали дадена
    // точка О (x, y) е вътре в окръжността К ((0,0), 5) и е
    // извън правоъгълника ((-1, 1), (5, 5).
    public static void main(String[] arguments){
        int x = 2, y = 3;
        Object inCircle = ((x * x + y * y) < 25) ?("Yes, it in"):("No");
        Object inRectangle = (((x<-1)||(x>5)||(y<1)||(y>5)) ? ("Yes, it in"):("No"));
        System.out.println("InCircle "+inCircle+ "InRecrangle "+inRectangle);
    }
}

