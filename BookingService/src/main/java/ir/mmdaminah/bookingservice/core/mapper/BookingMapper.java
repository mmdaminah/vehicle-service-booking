package ir.mmdaminah.bookingservice.core.mapper;

import ir.mmdaminah.bookingservice.core.entity.Booking;
import ir.mmdaminah.bookingservice.events.ServiceBookedEvent;
import org.springframework.stereotype.Component;

@Component
public class BookingMapper {

    public Booking toEntity(ServiceBookedEvent event) {
        Booking booking = new Booking();
        booking.setBookingId(event.getBookingId());
        booking.setServiceId(event.getServiceId());
        booking.setTechnicianId(event.getTechnicianId());
        booking.setCustomerId(event.getCustomerId());
        booking.setStartHour(Integer.parseInt(event.getStartTime().split(":")[0]));
        booking.setStartMinute(Integer.parseInt(event.getStartTime().split(":")[1]));
        booking.setDate(event.getDate());
        return booking;
    }

}
