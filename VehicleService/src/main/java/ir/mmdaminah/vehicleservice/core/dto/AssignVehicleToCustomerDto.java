package ir.mmdaminah.vehicleservice.core.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AssignVehicleToCustomerDto {
    @NotNull
    private String plateNumber;

    @NotNull
    @Length(min = 1, max = 30)
    private String color;

    @NotNull
    @Min(1940)
    @Max(2099)
    private Integer productionYear;

}
