package ir.mmdaminah.bookingservice.query;

import ir.mmdaminah.bookingservice.core.entity.Booking;
import ir.mmdaminah.bookingservice.core.mapper.BookingMapper;
import ir.mmdaminah.bookingservice.core.repository.BookingRepository;
import ir.mmdaminah.bookingservice.events.ServiceBookedEvent;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.modelling.command.RepositorySpanFactory;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class BookingEventsHandler {

    private final BookingRepository bookingRepository;
    private final BookingMapper bookingMapper;

    public BookingEventsHandler(BookingRepository bookingRepository, BookingMapper bookingMapper, RepositorySpanFactory repositorySpanFactory) {
        this.bookingRepository = bookingRepository;
        this.bookingMapper = bookingMapper;
    }

    @EventHandler
    public void handle(ServiceBookedEvent event) {
        Booking booking = bookingMapper.toEntity(event);
        bookingRepository.save(booking);

        log.info("BookingEventsHandler:ServiceBookedEvent: bookinId={}, serviceId={}, technicianId={}, customerId={}, startTime={}", event.getBookingId(), event.getServiceId(), event.getTechnicianId(), event.getCustomerId(), event.getStartTime());
    }

}
