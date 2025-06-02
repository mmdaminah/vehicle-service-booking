package ir.mmdaminah.servicecenterservice.core.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CreateServiceCenterDto {

    @NotNull
    @Min(5)
    @Max(50)
    private String name;

    @NotNull
    @Min(2)
    @Max(50)
    private String province;

    @NotNull
    @Min(2)
    @Max(50)
    private String city;

    @NotNull
    @Min(5)
    @Max(255)
    private String address;
}
