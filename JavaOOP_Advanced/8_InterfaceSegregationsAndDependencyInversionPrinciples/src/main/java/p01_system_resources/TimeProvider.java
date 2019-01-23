package p01_system_resources;

import java.lang.reflect.InvocationTargetException;

public interface TimeProvider {
    int getHour() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException;
}
