package alararestaurant.domain.entities;

import javax.persistence.*;
import java.util.List;

@Entity(name = "categories")
public class Category extends BaseEntity{

    private String name;
    private List<Item> items;

    @OneToMany(targetEntity = Item.class, mappedBy = "category",
            fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public Category() {
    }

    @Column(name = "name", nullable = false)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
