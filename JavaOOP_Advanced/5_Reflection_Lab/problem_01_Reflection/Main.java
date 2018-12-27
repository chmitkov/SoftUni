package problem_01_Reflection;

import java.lang.reflect.InvocationTargetException;
import java.sql.Ref;
import java.util.Arrays;

public class Main {
    public static void main(String[] args)
            throws NoSuchMethodException,
            IllegalAccessException, InvocationTargetException,
            InstantiationException {

        Class<Reflection> ref = Reflection.class;
        System.out.println(ref.getSimpleName());
        System.out.println(ref.getSuperclass().getSimpleName());

        Class[] interfaces = ref.getInterfaces();
        for (Class contract : interfaces) {
            System.out.println(contract);
        }

        Reflection instance = ref.getDeclaredConstructor().newInstance();
        System.out.println(instance);
    }
}
