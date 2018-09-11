package googleEx;

public class Parents {
    private String parentName;
    private String parentBirthday;

    public Parents(String parentName, String parentBirthday) {
        this.parentName = parentName;
        this.parentBirthday = parentBirthday;
    }

    public String getParentName() {
        return this.parentName;
    }

    public String getParentBirthday() {
        return this.parentBirthday;
    }

    @Override
    public String toString() {
        return String.format("%s %s%n", getParentName(), getParentBirthday());
    }
}
