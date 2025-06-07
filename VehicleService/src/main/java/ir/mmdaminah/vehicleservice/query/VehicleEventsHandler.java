package ir.mmdaminah.vehicleservice.query;

import ir.mmdaminah.vehicleservice.core.dto.VehicleDto;
import ir.mmdaminah.vehicleservice.core.entity.CustomerVehicle;
import ir.mmdaminah.vehicleservice.core.entity.Vehicle;
import ir.mmdaminah.vehicleservice.core.repository.CustomerVehicleRepository;
import ir.mmdaminah.vehicleservice.core.repository.VehicleRepository;
import ir.mmdaminah.vehicleservice.events.VehicleAssignedToCustomerEvent;
import ir.mmdaminah.vehicleservice.events.VehicleCreatedEvent;
import ir.mmdaminah.vehicleservice.query.queries.FindVehicleQuery;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.queryhandling.QueryUpdateEmitter;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class VehicleEventsHandler {

    private final VehicleRepository vehicleRepository;
    private final CustomerVehicleRepository customerVehicleRepository;
    private final QueryUpdateEmitter queryUpdateEmitter;

    public VehicleEventsHandler(VehicleRepository vehicleRepository,
                                CustomerVehicleRepository customerVehicleRepository,
                                QueryUpdateEmitter queryUpdateEmitter) {
        this.vehicleRepository = vehicleRepository;
        this.customerVehicleRepository = customerVehicleRepository;
        this.queryUpdateEmitter = queryUpdateEmitter;
    }

    @EventHandler
    public void handle(VehicleCreatedEvent event) {
        var vehicle = new Vehicle();

        BeanUtils.copyProperties(event, vehicle);

        vehicleRepository.save(vehicle);

        queryUpdateEmitter.emit(
                FindVehicleQuery.class,
                query -> true,
                new VehicleDto(
                        event.getVehicleId(),
                        event.getCompany(),
                        event.getModel()
                )
        );

        log.info("VehicleEventsHandler:VehicleCreatedEvent: vehicleId={}, company={}, model={}", event.getVehicleId(), event.getCompany(), event.getModel());
    }

    @EventHandler
    private void handle(VehicleAssignedToCustomerEvent event) {

        var vehicle = vehicleRepository.findById(event.getVehicleId());
        var customerVehicle = new CustomerVehicle();
        BeanUtils.copyProperties(event, customerVehicle);
        customerVehicle.setVehicle(vehicle.orElse(null));

        customerVehicleRepository.save(customerVehicle);

        log.info("VehicleEventsHandler:VehicleAssignedToCustomerEvent: event={}", event);
    }

}
