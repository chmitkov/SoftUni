package alararestaurant.domain.entities;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity(name = "items")
public class Item extends BaseEntity{

    private String name;
    private Category category;
    private BigDecimal price;
    private List<OrderItem> orderItems;

    public Item() {
    }

    @Column(name = "name", nullable = false)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @ManyToOne(optional = false, targetEntity = Category.class)
    @JoinColumn(name = "category_id",referencedColumnName = "id")
    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Column(name = "price", nullable = false)
    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @OneToMany(targetEntity = OrderItem.class, mappedBy = "item",
    fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }
}
