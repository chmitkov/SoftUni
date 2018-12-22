package alararestaurant.domain.entities;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity(name = "orders")
public class Order extends BaseEntity{

    private String customer;
    private LocalDateTime dateTime;
    private OrderType orderType;
    private Employee employee;
    private List<OrderItem> items;

    public Order() {
    }

    @Column(name = "customer", nullable = false, columnDefinition = "TEXT")
    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    @Column(name = "date_time", nullable = false)
    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    @Column(name = "type", columnDefinition = "ENUM('ForHere', 'ToGo') default 'ForHere'")
    @Enumerated(EnumType.STRING)
    public OrderType getOrderType() {
        return orderType;
    }

    public void setOrderType(OrderType orderType) {
        this.orderType = orderType;
    }

    @ManyToOne(optional = false, targetEntity = Employee.class)
    @JoinColumn(name = "employee_id", referencedColumnName = "id")
    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }


    @OneToMany(targetEntity = OrderItem.class, mappedBy = "order",
            fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    public List<OrderItem> getItems() {
        return items;
    }

    public void setItems(List<OrderItem> items) {
        this.items = items;
    }
}
