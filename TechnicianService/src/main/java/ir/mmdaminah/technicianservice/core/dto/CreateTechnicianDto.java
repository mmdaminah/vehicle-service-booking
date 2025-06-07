package ir.mmdaminah.technicianservice.core.dto;

import ir.mmdaminah.technicianservice.core.validation.WorkingDayProperty;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateTechnicianDto {

    @NotNull
    @Length(min = 2, max = 100)
    private String firstName;

    @NotNull
    @Length(min = 2, max = 100)
    private String lastName;
    private List<WorkingDayProperty> workingDays;
}
