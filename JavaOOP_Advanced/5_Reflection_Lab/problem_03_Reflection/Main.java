package problem_03_Reflection;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.*;

public class Main {
    public static void main(String[] args) {

        Reflection reflection = new Reflection();
        Set<Method> getters = new TreeSet<>(Comparator.comparing(Method::getName));
        Set<Method> setters = new TreeSet<>(Comparator.comparing(Method::getName));

        List<Field> fields = Arrays.asList(Reflection.class.getDeclaredFields());

        fields.sort(new Comparator<Field>() {
            @Override
            public int compare(Field firstField, Field secondField) {
                return firstField.getName().compareTo(secondField.getName());
            }
        });

        for (Field field : fields) {
            if (!Modifier.isPrivate(field.getModifiers())) {
                System.out.printf("%s must be private!%n", field.getName());
            }
        }

        Method[] methods = reflection.getClass().getDeclaredMethods();

        Arrays.stream(methods)
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

        getters.forEach(x -> {
            if (!Modifier.isPublic(x.getModifiers())) {
                System.out.printf("%s have to be public!%n", x.getName());
            }
        });

        setters.forEach(x -> {
            if (!Modifier.isPrivate(x.getModifiers())) {
                System.out.printf("%s have to be private!%n", x.getName());
            }
        });

    }
}
