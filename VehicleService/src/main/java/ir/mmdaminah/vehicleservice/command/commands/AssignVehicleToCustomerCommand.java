package ir.mmdaminah.vehicleservice.command.commands;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AssignVehicleToCustomerCommand {
    @TargetAggregateIdentifier
    private String customerVehicleId;
    private String customerId;
    private String vehicleId;
    private String plateNumber;
}
