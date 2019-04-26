package core.interfaces;

import javax.naming.OperationNotSupportedException;
import java.io.IOException;

public interface Engine {
    void run() throws IOException;

    String processCommand(String input) throws OperationNotSupportedException;
}
