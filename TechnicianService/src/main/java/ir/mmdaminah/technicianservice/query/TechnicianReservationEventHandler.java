package ir.mmdaminah.technicianservice.query;

import ir.mmdaminah.core.events.TechnicianReservedEvent;
import ir.mmdaminah.technicianservice.core.entity.TechnicianReservation;
import ir.mmdaminah.technicianservice.core.repository.TechnicianReservationRepository;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class TechnicianReservationEventHandler {

    private final TechnicianReservationRepository reservationRepository;

    public TechnicianReservationEventHandler(TechnicianReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    @EventHandler
    public void handle(TechnicianReservedEvent event) {
        var reservation = new TechnicianReservation();
        BeanUtils.copyProperties(event, reservation);

        reservationRepository.save(reservation);

        log.info("TechnicianReservationEventHandler: event = {}", event);
    }

}
