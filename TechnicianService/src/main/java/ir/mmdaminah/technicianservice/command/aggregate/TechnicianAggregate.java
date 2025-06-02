package ir.mmdaminah.technicianservice.command.aggregate;

import ir.mmdaminah.technicianservice.command.commands.CreateTechnicianCommand;
import ir.mmdaminah.technicianservice.core.validation.WorkingDayProperty;
import ir.mmdaminah.technicianservice.events.TechnicianCreatedEvent;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;
import org.springframework.beans.BeanUtils;

import java.util.List;

@Aggregate
@Slf4j
public class TechnicianAggregate {

    @AggregateIdentifier
    private String technicianId;
    private String firstName;
    private String lastName;
    private List<WorkingDayProperty> workingDays;

    public TechnicianAggregate() {}

    @CommandHandler
    public TechnicianAggregate(CreateTechnicianCommand command) {
        log.info("TechnicianAggregate:CreateTechnicianCommand: technicianId={}, firstName={}, lastName={}, workingHours={}", command.getTechnicianId(), command.getFirstName(), command.getLastName(), command.getWorkingDays().toString());

        var event = new TechnicianCreatedEvent();
        BeanUtils.copyProperties(command, event);

        AggregateLifecycle.apply(event);
    }

    @EventSourcingHandler
    public void on(TechnicianCreatedEvent event) {
        this.technicianId = event.getTechnicianId();
        this.firstName = event.getFirstName();
        this.lastName = event.getLastName();
        this.workingDays = event.getWorkingDays();
    }

}
