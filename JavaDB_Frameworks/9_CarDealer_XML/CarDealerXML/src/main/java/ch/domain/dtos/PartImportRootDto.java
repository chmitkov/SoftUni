package ch.domain.dtos;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "parts")
@XmlAccessorType(XmlAccessType.FIELD)
public class PartImportRootDto {

    @XmlElement(name = "part")
    private PartImportDto[] partImportDtos;

    public PartImportRootDto() {
    }

    public PartImportDto[] getPartImportDtos() {
        return partImportDtos;
    }

    public void setPartImportDtos(PartImportDto[] partImportDtos) {
        this.partImportDtos = partImportDtos;
    }
}
