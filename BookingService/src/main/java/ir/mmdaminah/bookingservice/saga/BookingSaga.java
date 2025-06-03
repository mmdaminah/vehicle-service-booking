package ir.mmdaminah.bookingservice.saga;

import ir.mmdaminah.bookingservice.events.ServiceBookedEvent;
import ir.mmdaminah.core.commands.ReserveTechnicianCommand;
import ir.mmdaminah.core.events.TechnicianReservedEvent;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.modelling.saga.SagaEventHandler;
import org.axonframework.modelling.saga.StartSaga;
import org.axonframework.spring.stereotype.Saga;

import java.util.UUID;

@Saga
public class BookingSaga {

    private transient CommandGateway commandGateway;

    @StartSaga
    @SagaEventHandler(associationProperty = "bookingId")
    public void handle(ServiceBookedEvent event) {

        var command = ReserveTechnicianCommand.builder()
                .reservationId(UUID.randomUUID().toString())
                .technicianId(event.getTechnicianId())
                .bookingId(event.getBookingId())
                .serviceId(event.getServiceId())
                .customerId(event.getCustomerId())
                .startTime(event.getStartTime())
                .date(event.getDate())
                .build();

        commandGateway.send(command);

    }

    public void handle(TechnicianReservedEvent event) {}

}
