package ir.mmdaminah.customerservice.command.aggregate;

import ir.mmdaminah.customerservice.command.commands.CreateCustomerCommand;
import ir.mmdaminah.customerservice.events.CustomerCreatedEvent;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;
import org.springframework.beans.BeanUtils;

@Aggregate
@Slf4j
public class CustomerAggregate {
    @AggregateIdentifier
    private String customerId;
    private String firstName;
    private String lastName;

    public CustomerAggregate() {
    }

    @CommandHandler
    public CustomerAggregate(CreateCustomerCommand command) {
        log.info("CustomerAggregate:CreateCustomerCommand: customerId={}, firstName={}, lastName={}", command.getCustomerId(), command.getFirstName(), command.getLastName());

        CustomerCreatedEvent event = new CustomerCreatedEvent();
        BeanUtils.copyProperties(command, event);

        AggregateLifecycle.apply(event);
    }

    @EventSourcingHandler
    public void on(CustomerCreatedEvent event) {
        this.customerId = event.getCustomerId();
        this.firstName = event.getFirstName();
        this.lastName = event.getLastName();
    }

}
