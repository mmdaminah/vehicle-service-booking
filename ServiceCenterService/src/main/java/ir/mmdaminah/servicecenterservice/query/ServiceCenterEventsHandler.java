package ir.mmdaminah.servicecenterservice.query;

import ir.mmdaminah.servicecenterservice.core.entity.ServiceCenter;
import ir.mmdaminah.servicecenterservice.core.repository.ServiceCenterRepository;
import ir.mmdaminah.servicecenterservice.events.ServiceCenterCreatedEvent;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class ServiceCenterEventsHandler {

    private ServiceCenterRepository serviceCenterRepository;

    public ServiceCenterEventsHandler(ServiceCenterRepository serviceCenterRepository) {
        this.serviceCenterRepository = serviceCenterRepository;
    }

    @EventHandler
    public void handle(ServiceCenterCreatedEvent event) {
        var serviceCenter = new ServiceCenter();
        BeanUtils.copyProperties(event, serviceCenter);

        serviceCenterRepository.save(serviceCenter);

        log.info("ServiceCenterEventsHandler:ServiceCenterCreatedEvent: serviceCenterId={}, name={}, province={}, city={}, address={}", event.getServiceCenterId(), event.getName(), event.getProvince(), event.getCity(), event.getAddress());
    }

}
