package ir.mmdaminah.technicianservice.command.commands;

import ir.mmdaminah.technicianservice.core.validation.WorkingDayProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreateTechnicianCommand {
    @TargetAggregateIdentifier
    private String technicianId;
    private String firstName;
    private String lastName;
    private List<WorkingDayProperty> workingDays;
}
