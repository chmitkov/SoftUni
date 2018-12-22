package alararestaurant.domain.dtos;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

public class ItemImportDto {

    @Expose
    @SerializedName("name")
    private String name;
    @Expose
    @SerializedName("price")
    private BigDecimal price;

    @Expose
    @SerializedName("category")
    private String category;

    public ItemImportDto() {
    }

    @NotNull
    @Size(min = 3, max = 30)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @NotNull
    @DecimalMin("0.01")
    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @NotNull
    @Size(min = 3, max = 30)
    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
