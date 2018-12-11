package problem_1_Jar_of_T;

public class Main {
    public static void main(String[] args) {

        Jar<String> jar = new Jar<>();

        jar.add("this");
        jar.add("this2");

        jar.getContent().forEach(System.out::println);

        System.out.println(jar.remove());

    }
}
