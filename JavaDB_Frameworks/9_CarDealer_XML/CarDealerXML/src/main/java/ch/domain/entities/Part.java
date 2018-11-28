package ch.domain.entities;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity(name = "parts")
public class Part extends BaseEntity{

    private String name;
    private BigDecimal price;
    private Integer quantity;
    private Supplier supplier;
    private List<Car> cars;

    public Part() {
    }

    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "price")
    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Column(name = "quantity")
    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    @ManyToOne(targetEntity = Supplier.class)
    @JoinColumn(name = "supplier_id", referencedColumnName = "id")
    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    @ManyToMany(targetEntity = Car.class, mappedBy = "parts")
    public List<Car> getCars() {
        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }
}
