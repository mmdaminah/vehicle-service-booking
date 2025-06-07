package ir.mmdaminah.vehicleservice.command.aggregate;

import ir.mmdaminah.vehicleservice.command.commands.AssignVehicleToCustomerCommand;
import ir.mmdaminah.vehicleservice.events.VehicleAssignedToCustomerEvent;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;
import org.springframework.beans.BeanUtils;

@Aggregate
public class CustomerVehicleAggregate {

    @AggregateIdentifier
    private String customerVehicleId;
    private String customerId;
    private String vehicleId;
    private String plateNumber;
    private String color;
    private Integer productionYear;

    public CustomerVehicleAggregate() {
    }

    @CommandHandler
    public CustomerVehicleAggregate(AssignVehicleToCustomerCommand command) {
        var event = new VehicleAssignedToCustomerEvent();
        BeanUtils.copyProperties(command, event);

        AggregateLifecycle.apply(event);
    }

    @EventSourcingHandler
    public void on(VehicleAssignedToCustomerEvent event) {
        this.customerVehicleId = event.getCustomerVehicleId();
        this.customerId = event.getCustomerId();
        this.vehicleId = event.getVehicleId();
        this.plateNumber = event.getPlateNumber();
        this.color = event.getColor();
        this.productionYear = event.getProductionYear();
    }

}
