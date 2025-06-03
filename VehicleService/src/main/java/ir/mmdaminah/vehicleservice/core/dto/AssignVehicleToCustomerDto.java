package ir.mmdaminah.vehicleservice.core.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AssignVehicleToCustomerDto {
    @NotNull
    private String plateNumber;
}
