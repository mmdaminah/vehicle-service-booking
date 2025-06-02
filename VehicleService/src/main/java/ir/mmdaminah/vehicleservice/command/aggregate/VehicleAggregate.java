package ir.mmdaminah.vehicleservice.command.aggregate;

import ir.mmdaminah.vehicleservice.command.commands.CreateVehicleCommand;
import ir.mmdaminah.vehicleservice.events.VehicleCreatedEvent;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;
import org.springframework.beans.BeanUtils;

@Aggregate
@Slf4j
public class VehicleAggregate {

    @AggregateIdentifier
    private String vehicleId;
    private String company;
    private String model;
    private String color;
    private Integer year;

    public VehicleAggregate(){}

    @CommandHandler
    private void handle(CreateVehicleCommand command){
        log.info("VehicleAggregate:CreateVehicleCommand: vehicleId={}, company={}, model={}, color={}, year={}", command.getVehicleId(), command.getCompany(), command.getModel(), command.getColor(), command.getYear());

        var vehicleCreatedEvent = new VehicleCreatedEvent();
        BeanUtils.copyProperties(command, vehicleCreatedEvent);

        AggregateLifecycle.apply(vehicleCreatedEvent);
    }

    @EventSourcingHandler
    private void on(VehicleCreatedEvent event){
        this.vehicleId = event.getVehicleId();
        this.company = event.getCompany();
        this.model = event.getModel();
        this.color = event.getColor();
        this.year = event.getYear();
    }
}
