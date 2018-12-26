package problem_02_WarningLevels;

import java.util.ArrayList;
import java.util.List;

public class Logger {
    private List<Message> messages;

    public Logger() {
        this.messages = new ArrayList<>();
    }

    public void addMessage(String neededImportance, String importance, String message) {
        if (Enum.valueOf(Importance.class, neededImportance.toUpperCase()).ordinal()
                <= Enum.valueOf(Importance.class, importance).ordinal()) {
            this.messages.add(new Message(importance,message));
        }
    }

    public Iterable<Message> getMessages(){
        return this.messages;
    }
}
