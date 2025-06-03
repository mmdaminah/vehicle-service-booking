package ir.mmdaminah.bookingservice.command.commands;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BookServiceCommand {
    @TargetAggregateIdentifier
    private String bookingId;
    private String serviceId;
    private String technicianId;
    private String customerId;
    private String startTime;
    private Date date;
}
