package ir.mmdaminah.customerservice.query;

import ir.mmdaminah.customerservice.core.entity.Customer;
import ir.mmdaminah.customerservice.core.repository.CustomerRepository;
import ir.mmdaminah.customerservice.events.CustomerCreatedEvent;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class CustomerEventsHandler {

    private final CustomerRepository customerRepository;

    public CustomerEventsHandler(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @EventHandler
    public void handle(CustomerCreatedEvent event) {
        Customer customer = new Customer();
        BeanUtils.copyProperties(event, customer);

        customerRepository.save(customer);

        log.info("CustomerEventsHandler:CustomerCreatedEvent: customerId={}, firstName={}, lastName={}", event.getCustomerId(), event.getFirstName(), event.getLastName());
    }

}
