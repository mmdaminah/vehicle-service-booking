package ir.mmdaminah.vehicleservice.command.commands;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateVehicleCommand {
    @TargetAggregateIdentifier
    private String vehicleId;
    private String company;
    private String model;
    private String color;
    private Integer year;
}
