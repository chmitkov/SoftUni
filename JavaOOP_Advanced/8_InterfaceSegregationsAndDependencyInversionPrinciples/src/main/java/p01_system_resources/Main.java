package p01_system_resources;

import java.lang.reflect.InvocationTargetException;

public class Main {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {

        TimeProvider timeProvider = new TimeProviderImpl();
        Writer writer = new WriterImpl();
        GreetingClock greetingClock = new GreetingClock(timeProvider, writer);
        greetingClock.greeting();
    }
}
