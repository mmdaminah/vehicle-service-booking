package ir.mmdaminah.bookingservice.command.aggregate;

import ir.mmdaminah.bookingservice.command.commands.BookServiceCommand;
import ir.mmdaminah.bookingservice.events.ServiceBookedEvent;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;
import org.springframework.beans.BeanUtils;

@Aggregate
@Slf4j
public class BookingAggregate {

    @AggregateIdentifier
    private String bookingId;
    private String serviceId;
    private String technicianId;
    private String customerId;
    private String startTime;

    public BookingAggregate() {}

    @CommandHandler
    public BookingAggregate(BookServiceCommand command) {
        log.info("BookingAggregate:BookServiceCommand {}", command);

        ServiceBookedEvent serviceBookedEvent = new ServiceBookedEvent();
        BeanUtils.copyProperties(command, serviceBookedEvent);

        AggregateLifecycle.apply(serviceBookedEvent);
    }

    @EventSourcingHandler
    public void on(ServiceBookedEvent event) {
        this.bookingId = event.getBookingId();
        this.serviceId = event.getServiceId();
        this.technicianId = event.getTechnicianId();
        this.customerId = event.getCustomerId();
        this.startTime = event.getStartTime();
    }

}
