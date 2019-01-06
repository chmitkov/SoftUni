package pr01HarvestingFields;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String classPath = "pr01HarvestingFields.RichSoilLand";

        Class<?> richSoilLand = Class.forName(classPath);

        Field[] allFields = richSoilLand.getDeclaredFields();

        String line;

        while (!"HARVEST".equals(line = br.readLine())) {
            switch (line) {
                case "protected":
                    Arrays.stream(allFields)
                            .filter(field -> Modifier.isProtected(field.getModifiers()))
                            .forEach(field -> System.out.printf("%s %s %s%n",
                                    Modifier.toString(field.getModifiers()),
                                    field.getType().getSimpleName(),
                                    field.getName()
                            ));
                    break;
                case "private":
                    Arrays.stream(allFields)
                            .filter(field -> Modifier.isPrivate(field.getModifiers()))
                            .forEach(field -> System.out.printf("%s %s %s%n",
                                    Modifier.toString(field.getModifiers()),
                                    field.getType().getSimpleName(),
                                    field.getName()
                            ));
                    break;
                case "public":
                    Arrays.stream(allFields)
                            .filter(field -> Modifier.isPublic(field.getModifiers()))
                            .forEach(field -> System.out.printf("%s %s %s%n",
                                    Modifier.toString(field.getModifiers()),
                                    field.getType().getSimpleName(),
                                    field.getName()
                            ));
                    break;
                case "all":
                    Arrays.stream(allFields)
                            .forEach(field -> System.out.printf("%s %s %s%n",
                                    Modifier.toString(field.getModifiers()),
                                    field.getType().getSimpleName(),
                                    field.getName()
                            ));
                    break;
            }
        }

        System.out.println();
    }
}
