package familyTree;

import java.util.ArrayList;
import java.util.List;

public class PersonFromFamily {
    private String firstName;
    private String lastName;
    private String birthday;
    private List<PersonFromFamily> parents;
    private List<PersonFromFamily> children;

    public PersonFromFamily() {
        this.parents = new ArrayList<>();
        this.children = new ArrayList<>();
    }

    public PersonFromFamily(String nameOrDate) {
        this();
        if (Character.isDigit(nameOrDate.charAt(0))) {
            setBirthday(nameOrDate);
        } else {
            setFirstName(nameOrDate.split(" ")[0]);
            setLastName(nameOrDate.split(" ")[1]);
        }

    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public String getBirthday() {
        return this.birthday;
    }

    public List<PersonFromFamily> getChildren() {
        return this.children;
    }

    public List<PersonFromFamily> getParents() {
        return this.parents;
    }

    @Override
    public String toString() {
        return String.format("%s %s %s\n",
                this.firstName, this.lastName, this.birthday);
    }
}
