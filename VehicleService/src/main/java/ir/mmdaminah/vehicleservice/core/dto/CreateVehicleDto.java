package ir.mmdaminah.vehicleservice.core.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreateVehicleDto {

    @NotNull
    @Length(min = 1, max = 50)
    private String company;

    @NotNull
    @Length(min = 1, max = 60)
    private String model;

}
