package ir.mmdaminah.vehicleservice.events;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class VehicleCreatedEvent {
    private String vehicleId;
    private String company;
    private String model;
    private String color;
    private Integer year;
}
