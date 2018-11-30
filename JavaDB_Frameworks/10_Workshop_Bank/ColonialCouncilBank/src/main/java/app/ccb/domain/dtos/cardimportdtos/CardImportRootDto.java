package app.ccb.domain.dtos.cardimportdtos;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "cards")
@XmlAccessorType(XmlAccessType.FIELD)
public class CardImportRootDto {

    @XmlElement(name="card")
    private CardImportDto[] cardImportDtos;

    public CardImportRootDto() {
    }

    public CardImportDto[] getCardImportDtos() {
        return cardImportDtos;
    }

    public void setCardImportDtos(CardImportDto[] cardImportDtos) {
        this.cardImportDtos = cardImportDtos;
    }
}
