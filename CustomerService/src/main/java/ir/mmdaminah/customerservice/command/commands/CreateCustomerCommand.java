package ir.mmdaminah.customerservice.command.commands;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateCustomerCommand {
    @TargetAggregateIdentifier
    private String customerId;
    private String firstName;
    private String lastName;
}
