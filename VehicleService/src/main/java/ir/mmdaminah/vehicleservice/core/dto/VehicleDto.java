package ir.mmdaminah.vehicleservice.core.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class VehicleDto {
    private String vehicleId;
    private String company;
    private String model;
    private String color;
    private Integer productionYear;
}
