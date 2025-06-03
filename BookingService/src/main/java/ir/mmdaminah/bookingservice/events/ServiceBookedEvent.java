package ir.mmdaminah.bookingservice.events;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ServiceBookedEvent {
    private String bookingId;
    private String serviceId;
    private String technicianId;
    private String customerId;
    private String startTime;
    private Date date;
}
