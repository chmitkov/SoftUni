package p03_Scale;

public class Main {
    public static void main(String[] args) {
        Scale<Integer> scale = new Scale<>(5, 8);
        System.out.println(scale.getHeavier());
    }
}
