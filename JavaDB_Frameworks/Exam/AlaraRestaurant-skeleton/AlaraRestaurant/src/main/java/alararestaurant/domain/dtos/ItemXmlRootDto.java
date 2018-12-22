package alararestaurant.domain.dtos;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "items")
@XmlAccessorType(XmlAccessType.FIELD)
public class ItemXmlRootDto {

    @XmlElement(name = "item")
    private ItemXmlDto[] itemXmlDtos;

    public ItemXmlRootDto() {
    }

    public ItemXmlDto[] getItemXmlDtos() {
        return itemXmlDtos;
    }

    public void setItemXmlDtos(ItemXmlDto[] itemXmlDtos) {
        this.itemXmlDtos = itemXmlDtos;
    }
}
