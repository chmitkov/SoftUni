package alararestaurant.domain.dtos;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "orders")
@XmlAccessorType(XmlAccessType.FIELD)
public class OrderXmlImportRootDto {

    @XmlElement(name = "order")
    private OrderXmlImportDto[] orderXmlImportDtos;

    public OrderXmlImportRootDto() {
    }

    public OrderXmlImportDto[] getOrderXmlImportDtos() {
        return orderXmlImportDtos;
    }

    public void setOrderXmlImportDtos(OrderXmlImportDto[] orderXmlImportDtos) {
        this.orderXmlImportDtos = orderXmlImportDtos;
    }
}
