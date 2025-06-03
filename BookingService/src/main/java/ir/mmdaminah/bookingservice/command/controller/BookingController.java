package ir.mmdaminah.bookingservice.command.controller;

import ir.mmdaminah.bookingservice.command.commands.BookServiceCommand;
import ir.mmdaminah.bookingservice.core.dto.BookServiceDto;
import jakarta.validation.Valid;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/booking")
public class BookingController {

    private final CommandGateway commandGateway;

    public BookingController(CommandGateway commandGateway) {
        this.commandGateway = commandGateway;
    }

    @PostMapping
    public String bookAService(@Valid @RequestBody BookServiceDto dto){

        BookServiceCommand command = BookServiceCommand.builder()
                .bookingId(UUID.randomUUID().toString())
                .serviceId(dto.getServiceId())
                .technicianId(dto.getTechnicianId())
                .customerId(dto.getCustomerId())
                .startTime(dto.getStartTime())
                .date(dto.getDate())
                .build();

        String result = commandGateway.sendAndWait(command);
        return result;
    }

}
