package ir.mmdaminah.technicianservice.events;

import ir.mmdaminah.technicianservice.core.data.Day;
import ir.mmdaminah.technicianservice.core.validation.WorkingDayProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TechnicianCreatedEvent {
    private String technicianId;
    private String firstName;
    private String lastName;
    private List<WorkingDayProperty> workingDays;
}
