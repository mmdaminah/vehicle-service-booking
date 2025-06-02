package ir.mmdaminah.bookingservice.events;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ServiceBookedEvent {
    private String bookingId;
    private String serviceId;
    private String technicianId;
    private String customerId;
    private String startTime;
}
