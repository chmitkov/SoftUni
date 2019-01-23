package p01_system_resources;

import java.lang.reflect.InvocationTargetException;
import java.time.LocalTime;

public class GreetingClock {

    private TimeProvider time;
    private Writer writer;

    public GreetingClock(TimeProvider time, Writer writer) {
        this.time = time;
        this.writer = writer;
    }

    public void greeting() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        if (time.getHour() < 12) {
            this.writer.write("Good morning...");
        } else if (time.getHour() < 18) {
            this.writer.write("Good afternoon...");
        } else {
            this.writer.write("Good evening...");
        }
    }
}
