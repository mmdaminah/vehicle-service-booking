package ir.mmdaminah.vehicleservice.events;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VehicleAssignedToCustomerEvent {
    private String customerVehicleId;
    private String customerId;
    private String vehicleId;
    private String plateNumber;
}
