package alararestaurant.domain.entities;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity(name = "positions")
public class Position extends BaseEntity{

    private String name;

    public Position() {
    }

    @Column(name = "name", nullable = false)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
