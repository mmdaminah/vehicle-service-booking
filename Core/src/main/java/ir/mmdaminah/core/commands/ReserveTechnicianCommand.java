package ir.mmdaminah.core.commands;

import lombok.Builder;
import lombok.Value;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

import java.util.Date;

@Value
@Builder
public class ReserveTechnicianCommand {
    @TargetAggregateIdentifier
    private String reservationId;
    private String technicianId;
    private String bookingId;
    private String serviceId;
    private String customerId;
    private String startTime;
    private Date date;
}
