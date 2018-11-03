package problem_5_BorderControl;

public class Robot implements HavingId {
    private String model;
    private String id;

    public Robot(String model, String id) {
        this.id = id;
        this.model = model;
    }

    @Override
    public String getId() {
        return this.id;
    }
}
