package problem_3_GenericScale;

public class Main {
    public static void main(String[] args) {

        Scale<String> stringScale = new Scale<>("left", "right");

        System.out.println(stringScale.getHeavier());
    }
}
