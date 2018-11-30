package app.ccb.domain.dtos.bankaccountdtos;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "bank-accounts")
@XmlAccessorType(XmlAccessType.FIELD)
public class BankAccountImportRootDto {

    @XmlElement(name = "bank-account")
    private BankAccountImportDto[] bankAccountImportDtos;

    public BankAccountImportRootDto() {
    }

    public BankAccountImportDto[] getBankAccountImportDtos() {
        return bankAccountImportDtos;
    }

    public void setBankAccountImportDtos(BankAccountImportDto[] bankAccountImportDtos) {
        this.bankAccountImportDtos = bankAccountImportDtos;
    }
}
