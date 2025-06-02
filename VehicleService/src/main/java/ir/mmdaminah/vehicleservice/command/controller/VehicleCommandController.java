package ir.mmdaminah.vehicleservice.command.controller;

import ir.mmdaminah.vehicleservice.command.commands.CreateVehicleCommand;
import ir.mmdaminah.vehicleservice.core.dto.CreateVehicleDto;
import jakarta.validation.Valid;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/vehicles")
public class VehicleCommandController {

    private final CommandGateway commandGateway;

    public VehicleCommandController(CommandGateway commandGateway) {
        this.commandGateway = commandGateway;
    }

    @PostMapping
    public String createVehicle(@Valid @RequestBody CreateVehicleDto createVehicleDto) {
        String result = commandGateway.sendAndWait(
                CreateVehicleCommand.builder()
                        .vehicleId(UUID.randomUUID().toString())
                        .company(createVehicleDto.getCompany())
                        .model(createVehicleDto.getModel())
                        .color(createVehicleDto.getColor())
                        .year(createVehicleDto.getYear())
        );

        return result;
    }

}
