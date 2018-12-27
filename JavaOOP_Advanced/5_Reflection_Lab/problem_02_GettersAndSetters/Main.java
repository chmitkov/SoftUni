package problem_02_GettersAndSetters;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        Set<Method> getters = new TreeSet<>(Comparator.comparing(Method::getName));
        Set<Method> setters = new TreeSet<>(Comparator.comparing(Method::getName));

        Method[] declaredMethods = Reflection.class.getDeclaredMethods();
        //Arrays.stream(declaredMethods).forEach(x -> System.out.println(x.getName()));

        Arrays.stream(declaredMethods)
                .forEach(x -> {
                    if (x.getName().startsWith("get")
                            && x.getParameterTypes().length == 0) {
                        getters.add(x);
                    } else if (x.getName().startsWith("set")
                            && x.getParameterTypes().length == 1
                            && void.class.equals(x.getReturnType())) {
                        setters.add(x);
                    }
                });

        getters.forEach(method -> {
            System.out.printf("%s will return %s%n",
                    method.getName(),
                    method.getReturnType().getSimpleName()
            );
        });

        setters.forEach(method -> {
            System.out.printf("%s and will set field of %s%n",
                    method.getName(), method.getParameterTypes()[0].getSimpleName());
        });


    }
}
