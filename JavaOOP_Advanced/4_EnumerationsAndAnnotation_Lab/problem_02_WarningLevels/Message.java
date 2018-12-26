package problem_02_WarningLevels;

public class Message {
    private Importance importance;
    private String message;

    public Message(String importance, String message){
        this.importance = Enum.valueOf(Importance.class, importance.toUpperCase());
        this.message = message;
    }

    @Override
    public String toString() {
        return String.format("%s: %s", this.importance.name(), this.message);
    }
}
