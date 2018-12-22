package alararestaurant.domain.dtos;

import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "order")
@XmlAccessorType(XmlAccessType.FIELD)
public class OrderXmlImportDto {

    @XmlElement(name = "customer")
    private String customer;

    @XmlElement(name = "employee")
    private String employee;

    @XmlElement(name = "date-time")
    private String dateTime;

    @XmlElement(name = "type")
    private String type;

    @XmlElement(name = "items")
    private ItemXmlRootDto items;

    public OrderXmlImportDto() {
    }

    @NotNull
    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    @NotNull
    public String getEmployee() {
        return employee;
    }

    public void setEmployee(String employee) {
        this.employee = employee;
    }

    @NotNull
    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    @NotNull
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @NotNull
    public ItemXmlRootDto getItems() {
        return items;
    }

    public void setItems(ItemXmlRootDto items) {
        this.items = items;
    }
}
