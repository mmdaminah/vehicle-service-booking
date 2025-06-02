package ir.mmdaminah.servicecenterservice.command.commands;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateServiceCenterCommand {
    @TargetAggregateIdentifier
    private String serviceCenterId;
    private String name;
    private String province;
    private String city;
    private String address;
}
