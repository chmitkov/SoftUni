package bookshopsystemapp.domain.entities;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity(name = "authors")
public class Author extends BaseEntity{

    private String firstName;
    private String lastName;

    public Author() {
    }

    @Column(name = "first_name")
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Column(name = "last_name", nullable = false  )
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
