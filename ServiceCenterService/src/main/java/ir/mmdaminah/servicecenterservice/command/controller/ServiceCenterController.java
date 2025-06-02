package ir.mmdaminah.servicecenterservice.command.controller;

import ir.mmdaminah.servicecenterservice.command.commands.CreateServiceCenterCommand;
import ir.mmdaminah.servicecenterservice.core.dto.CreateServiceCenterDto;
import jakarta.validation.Valid;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/service-center")
public class ServiceCenterController {

    private final CommandGateway commandGateway;

    public ServiceCenterController(CommandGateway commandGateway) {
        this.commandGateway = commandGateway;
    }

    @PostMapping
    public String createServiceCenter(@Valid @RequestBody CreateServiceCenterDto dto) {

        var command = CreateServiceCenterCommand.builder()
                .serviceCenterId(UUID.randomUUID().toString())
                .name(dto.getName())
                .province(dto.getProvince())
                .city(dto.getCity())
                .address(dto.getAddress())
                .build();

        String result = commandGateway.sendAndWait(command);

        return result;
    }

}
