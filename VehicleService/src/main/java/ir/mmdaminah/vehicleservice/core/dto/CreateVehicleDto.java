package ir.mmdaminah.vehicleservice.core.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreateVehicleDto {

    @NotNull
    @Max(50)
    private String company;

    @NotNull
    @Max(60)
    private String model;

    @NotNull
    @Max(30)
    private String color;

    @NotNull
    @Min(1940)
    @Max(2099)
    private Integer year;
}
