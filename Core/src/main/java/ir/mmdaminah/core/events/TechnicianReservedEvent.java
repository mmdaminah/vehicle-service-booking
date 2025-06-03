package ir.mmdaminah.core.events;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Value;

import java.util.Date;

@Data
@NoArgsConstructor()
@AllArgsConstructor
public class TechnicianReservedEvent {
    private String reservationId;
    private String technicianId;
    private String bookingId;
    private String serviceId;
    private String customerId;
    private String startTime;
    private Date date;
}
