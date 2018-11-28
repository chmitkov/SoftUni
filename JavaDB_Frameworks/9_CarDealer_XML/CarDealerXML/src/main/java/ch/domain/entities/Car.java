package ch.domain.entities;

import javax.persistence.*;
import java.util.List;

@Entity
public class Car extends BaseEntity {

    private String make;
    private String model;
    private Double travelledDistance;
    private List<Part> parts;
    private List<Sale> sales;


    public Car() {
    }

    @Column(name = "make")
    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    @Column(name = "model")
    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Column(name = "travelled_distance")
    public Double getTravelledDistance() {
        return travelledDistance;
    }

    public void setTravelledDistance(Double travelledDistance) {
        this.travelledDistance = travelledDistance;
    }

    @ManyToMany(targetEntity = Part.class)
    @JoinTable(name = "parts_cars",
            joinColumns = @JoinColumn(name = "car_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "part_id", referencedColumnName = "id")
    )
    public List<Part> getParts() {
        return parts;
    }

    public void setParts(List<Part> parts) {
        this.parts = parts;
    }


    @OneToMany(targetEntity = Sale.class, mappedBy = "car")
    public List<Sale> getSales() {
        return sales;
    }

    public void setSales(List<Sale> sales) {
        this.sales = sales;
    }
}
