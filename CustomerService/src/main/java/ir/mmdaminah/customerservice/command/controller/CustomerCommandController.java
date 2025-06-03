package ir.mmdaminah.customerservice.command.controller;

import ir.mmdaminah.customerservice.command.commands.CreateCustomerCommand;
import ir.mmdaminah.customerservice.core.dto.CreateCustomerDto;
import ir.mmdaminah.customerservice.core.dto.CustomerDto;
import ir.mmdaminah.customerservice.core.repository.CustomerRepository;
import ir.mmdaminah.customerservice.query.queries.FindCustomerQuery;
import jakarta.validation.Valid;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.queryhandling.QueryGateway;
import org.axonframework.queryhandling.SubscriptionQueryResult;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/customers")
public class CustomerCommandController {

    private final CommandGateway commandGateway;
    private final QueryGateway queryGateway;

    public CustomerCommandController(CommandGateway commandGateway, QueryGateway queryGateway) {
        this.commandGateway = commandGateway;
        this.queryGateway = queryGateway;
    }

    @PostMapping
    public CustomerDto createCustomer(@Valid @RequestBody CreateCustomerDto createCustomerDto) {
        String customerId = UUID.randomUUID().toString();

        SubscriptionQueryResult<CustomerDto, CustomerDto> customer = queryGateway.subscriptionQuery(
                new FindCustomerQuery(customerId),
                CustomerDto.class,
                CustomerDto.class
        );

        var command = CreateCustomerCommand.builder()
                .customerId(customerId)
                .firstName(createCustomerDto.getFirstName())
                .lastName(createCustomerDto.getLastName())
                .build();

        try {
            commandGateway.sendAndWait(command);
            return customer.updates().blockFirst();
        } finally {
            customer.close();
        }
    }

}
