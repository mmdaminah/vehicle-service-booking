package ir.mmdaminah.bookingservice.core.repository;

import ir.mmdaminah.bookingservice.core.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking, String> {
}
