package pr02PrivateClassFiddling;

import pr02PrivateClassFiddling.com.BlackBoxInt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchFieldException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String classPath = "pr02PrivateClassFiddling.com.BlackBoxInt";
        Class<?> myClass = Class.forName(classPath);

        Constructor declaredConstructor = myClass.getDeclaredConstructor(int.class);
        declaredConstructor.setAccessible(true);

        BlackBoxInt blackBoxInt = (BlackBoxInt) declaredConstructor.newInstance(0);

        String line;

        while (!"END".equals(line = br.readLine())) {
			String[] commands = line.split("_");

            Method declaredMethod = blackBoxInt.getClass()
                    .getDeclaredMethod(commands[0], int.class);
            declaredMethod.setAccessible(true);

            declaredMethod.invoke(blackBoxInt,Integer.valueOf(commands[1]));

            Field field = blackBoxInt.getClass()
                    .getDeclaredField("innerValue");

            field.setAccessible(true);

            System.out.println(field.get(blackBoxInt));

        }


        System.out.println();


    }
}
