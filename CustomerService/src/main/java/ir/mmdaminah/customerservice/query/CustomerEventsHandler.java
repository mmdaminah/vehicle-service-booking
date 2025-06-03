package ir.mmdaminah.customerservice.query;

import ir.mmdaminah.customerservice.core.dto.CustomerDto;
import ir.mmdaminah.customerservice.core.entity.Customer;
import ir.mmdaminah.customerservice.core.repository.CustomerRepository;
import ir.mmdaminah.customerservice.events.CustomerCreatedEvent;
import ir.mmdaminah.customerservice.query.queries.FindCustomerQuery;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.queryhandling.QueryUpdateEmitter;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class CustomerEventsHandler {

    private final CustomerRepository customerRepository;
    private final QueryUpdateEmitter queryUpdateEmitter;

    public CustomerEventsHandler(CustomerRepository customerRepository, QueryUpdateEmitter queryUpdateEmitter) {
        this.customerRepository = customerRepository;
        this.queryUpdateEmitter = queryUpdateEmitter;
    }

    @EventHandler
    public void handle(CustomerCreatedEvent event) {
        Customer customer = new Customer();
        BeanUtils.copyProperties(event, customer);

        customerRepository.save(customer);

        queryUpdateEmitter.emit(
                FindCustomerQuery.class,
                query -> true,
                new CustomerDto(event.getCustomerId(), event.getFirstName(), event.getLastName())
        );

        log.info("CustomerEventsHandler:CustomerCreatedEvent: customerId={}, firstName={}, lastName={}", event.getCustomerId(), event.getFirstName(), event.getLastName());
    }

}
