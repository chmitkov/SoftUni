package googleEx;

public class Children {
    private String childrenName;
    private String childrenBirthday;

    public Children(String childrenName, String childrenBirthday) {
        this.childrenName = childrenName;
        this.childrenBirthday = childrenBirthday;
    }

    public String getChildrenName() {
        return this.childrenName;
    }

    public String getChildrenBirthday() {
        return this.childrenBirthday;
    }

    @Override
    public String toString() {
        return String.format("%s %s%n", getChildrenName(),getChildrenBirthday());
    }
}
