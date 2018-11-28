package ch.domain.dtos;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

@XmlRootElement(name = "suppliers")
@XmlAccessorType(XmlAccessType.FIELD)
public class SupplierImportRootDto implements Serializable {

    @XmlElement(name = "supplier")
    private SupplierImportDto[] supplierImportDtos;

    public SupplierImportRootDto() {
    }

    public SupplierImportDto[] getSupplierImportDtos() {
        return supplierImportDtos;
    }

    public void setSupplierImportDtos(SupplierImportDto[] supplierImportDtos) {
        this.supplierImportDtos = supplierImportDtos;
    }
}
