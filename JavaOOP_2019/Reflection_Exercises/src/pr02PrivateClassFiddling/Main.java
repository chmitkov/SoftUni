package pr02PrivateClassFiddling;

import pr02PrivateClassFiddling.com.BlackBoxInt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {

    public static void main(String[] args) throws IOException, ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchFieldException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line;
        String fullClassPath = "pr02PrivateClassFiddling.com.BlackBoxInt";
        Class blackBoxClass = Class.forName(fullClassPath);
        Constructor<?> constructor = blackBoxClass.getDeclaredConstructor();
        constructor.setAccessible(true);
        BlackBoxInt myBox = (BlackBoxInt) constructor.newInstance();
        Field field = blackBoxClass.getDeclaredField("innerValue");
        field.setAccessible(true);

        while (!"END".equals(line = br.readLine())) {
            String[] commands = line.split("_");
            String action = commands[0];
            int value = Integer.parseInt(commands[1]);

            Method method = blackBoxClass.getDeclaredMethod(action, int.class);
            method.setAccessible(true);
            method.invoke(myBox, value);

            System.out.println(field.get(myBox));
        }
    }
}
