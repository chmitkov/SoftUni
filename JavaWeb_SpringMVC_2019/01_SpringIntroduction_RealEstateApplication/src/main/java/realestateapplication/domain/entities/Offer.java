package realestateapplication.domain.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;

@Entity
@Table(name = "offers")
public class Offer extends BaseEntity {

    private BigDecimal apartmentRent;
    private String apartmentType;
    private BigDecimal agencyCommission;

    public Offer() {
    }

    @Column(name = "apartment_rent", nullable = false)
    public BigDecimal getApartmentRent() {
        return apartmentRent;
    }

    public void setApartmentRent(BigDecimal apartmentRent) {
        this.apartmentRent = apartmentRent;
    }

    @Column(name = "apartment_type", nullable = false)
    public String getApartmentType() {
        return apartmentType;
    }


    public void setApartmentType(String apartmentType) {
        this.apartmentType = apartmentType;
    }

    @Column(name = "agency_commission", nullable = false)
    public BigDecimal getAgencyCommission() {
        return agencyCommission;
    }


    public void setAgencyCommission(BigDecimal agencyCommission) {
        this.agencyCommission = agencyCommission;
    }
}
