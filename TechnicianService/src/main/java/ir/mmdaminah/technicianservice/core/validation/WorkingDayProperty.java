package ir.mmdaminah.technicianservice.core.validation;

import ir.mmdaminah.technicianservice.core.data.Day;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WorkingDayProperty {

    @NotNull
    private Day workingDay;

    // format should be like HH:MM-HH:MM
    private List<@ValidTimeFormat String> workingTimes;
}
