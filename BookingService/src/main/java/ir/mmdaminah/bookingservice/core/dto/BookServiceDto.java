package ir.mmdaminah.bookingservice.core.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookServiceDto {

    @NotNull
    private String serviceId;

    @NotNull
    private String technicianId;

    @NotNull
    private String customerId;

    @NotNull
    private String startTime;

    @NotNull
    private Date date;
}
