package ir.mmdaminah.vehicleservice.query;

import ir.mmdaminah.vehicleservice.core.entity.Vehicle;
import ir.mmdaminah.vehicleservice.core.repository.VehicleRepository;
import ir.mmdaminah.vehicleservice.events.VehicleCreatedEvent;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class VehicleEventsHandler {

    private final VehicleRepository vehicleRepository;

    public VehicleEventsHandler(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    @EventHandler
    private void handle(VehicleCreatedEvent event) {
        var vehicle = new Vehicle();

        BeanUtils.copyProperties(event, vehicle);

        vehicleRepository.save(vehicle);

        log.info("VehicleEventsHandler:VehicleCreatedEvent: vehicleId={}, comapny={}, model={}, color={}, year={}", event.getVehicleId(), event.getCompany(), event.getModel(), event.getColor(), event.getYear());
    }

}
