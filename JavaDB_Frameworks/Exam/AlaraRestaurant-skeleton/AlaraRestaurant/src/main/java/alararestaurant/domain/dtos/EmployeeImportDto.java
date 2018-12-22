package alararestaurant.domain.dtos;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class EmployeeImportDto {

    @Expose
    @SerializedName("name")
    private String name;
    @Expose
    @SerializedName("age")
    private Integer age;
    @Expose
    @SerializedName("position")
    private String position;


    public EmployeeImportDto() {
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
    @Min(15)
    @Max(80)
    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @NotNull
    @Size(min = 3, max = 30)
    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
}
