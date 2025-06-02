package ir.mmdaminah.customerservice.command.controller;

import ir.mmdaminah.customerservice.command.commands.CreateCustomerCommand;
import ir.mmdaminah.customerservice.core.dto.CreateCustomerDto;
import jakarta.validation.Valid;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/customer")
public class CustomerCommandController {

    private CommandGateway commandGateway;

    @PostMapping
    public String createCustomer(@Valid @RequestBody CreateCustomerDto createCustomerDto) {


        String result = commandGateway.sendAndWait(
                CreateCustomerCommand.builder()
                        .customerId(UUID.randomUUID().toString())
                        .firstName(createCustomerDto.getFirstName())
                        .lastName(createCustomerDto.getLastName())
                        .build()
        );
        return result;
    }

}
