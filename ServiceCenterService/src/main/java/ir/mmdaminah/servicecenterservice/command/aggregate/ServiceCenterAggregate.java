package ir.mmdaminah.servicecenterservice.command.aggregate;

import ir.mmdaminah.servicecenterservice.command.commands.CreateServiceCenterCommand;
import ir.mmdaminah.servicecenterservice.events.ServiceCenterCreatedEvent;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;
import org.springframework.beans.BeanUtils;

@Aggregate
@Slf4j
public class ServiceCenterAggregate {

    @AggregateIdentifier
    private String serviceCenterId;
    private String name;
    private String province;
    private String city;
    private String address;

    public ServiceCenterAggregate() {
    }

    @CommandHandler
    public void handle(CreateServiceCenterCommand command) {
        log.info("ServiceCenterAggregate:CreateServiceCenterCommand: serviceCenterId={}, name={}, province={}, city={}, address={}", command.getServiceCenterId(), command.getName(), command.getProvince(), command.getCity(), command.getAddress());

        var ServiceCenterCreatedEven = new ServiceCenterCreatedEvent();
        BeanUtils.copyProperties(command, ServiceCenterCreatedEven);

        AggregateLifecycle.apply(ServiceCenterCreatedEven);
    }

    @EventSourcingHandler
    public void on(ServiceCenterCreatedEvent event) {
        this.serviceCenterId = event.getServiceCenterId();
        this.name = event.getName();
        this.province = event.getProvince();
        this.city = event.getCity();
        this.address = event.getAddress();
    }

}
