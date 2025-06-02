package ir.mmdaminah.technicianservice.query;

import ir.mmdaminah.technicianservice.core.mapper.TechnicianMapper;
import ir.mmdaminah.technicianservice.core.repository.TechnicianRepository;
import ir.mmdaminah.technicianservice.events.TechnicianCreatedEvent;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class TechnicianEventsHandler {

    private final TechnicianRepository technicianRepository;
    private final TechnicianMapper technicianMapper;

    public TechnicianEventsHandler(
            TechnicianRepository technicianRepository,
            TechnicianMapper technicianMapper
    ) {
        this.technicianRepository = technicianRepository;
        this.technicianMapper = technicianMapper;
    }

    @EventHandler
    public void handle(TechnicianCreatedEvent event) {
        var technician = technicianMapper.toEntity(event);
        technicianRepository.save(technician);

        log.info("TechnicianEventsHandler:TechnicianCreatedEvent: technicianId={}, firstName={}, lastName={}, workingDays={}", technician.getTechnicianId(), technician.getFirstName(), technician.getLastName(), technician.getWorkingDays().toString());
    }

}
