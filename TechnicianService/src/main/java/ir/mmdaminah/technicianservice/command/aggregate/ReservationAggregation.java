package ir.mmdaminah.technicianservice.command.aggregate;

import ir.mmdaminah.core.commands.ReserveTechnicianCommand;
import ir.mmdaminah.core.events.TechnicianReservedEvent;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;
import org.springframework.beans.BeanUtils;

import java.util.Date;

@Aggregate
public class ReservationAggregation {
    @AggregateIdentifier
    private String reservationId;
    private String technicianId;
    private String bookingId;
    private String serviceId;
    private String customerId;
    private String startTime;
    private Date date;

    public ReservationAggregation() {}

    @CommandHandler
    public ReservationAggregation(ReserveTechnicianCommand command) {
        var event = new TechnicianReservedEvent();
        BeanUtils.copyProperties(command, event);

        AggregateLifecycle.apply(event);
    }

    @EventSourcingHandler
    public void on(TechnicianReservedEvent event) {
       this.reservationId = event.getReservationId();
       this.technicianId = event.getTechnicianId();
       this.bookingId = event.getBookingId();
       this.serviceId = event.getServiceId();
       this.customerId = event.getCustomerId();
       this.startTime = event.getStartTime();
       this.date = event.getDate();
    }


}
