package ir.mmdaminah.technicianservice.core.repository;

import ir.mmdaminah.technicianservice.core.entity.TechnicianReservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TechnicianReservationRepository extends JpaRepository<TechnicianReservation, String> {
}
