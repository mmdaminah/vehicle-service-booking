package ir.mmdaminah.vehicleservice.command.controller;

import ir.mmdaminah.vehicleservice.command.commands.AssignVehicleToCustomerCommand;
import ir.mmdaminah.vehicleservice.command.commands.CreateVehicleCommand;
import ir.mmdaminah.vehicleservice.core.dto.AssignVehicleToCustomerDto;
import ir.mmdaminah.vehicleservice.core.dto.CreateVehicleDto;
import ir.mmdaminah.vehicleservice.core.dto.VehicleDto;
import ir.mmdaminah.vehicleservice.core.repository.VehicleRepository;
import ir.mmdaminah.vehicleservice.query.queries.FindVehicleQuery;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.queryhandling.QueryGateway;
import org.axonframework.queryhandling.SubscriptionQueryResult;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/vehicles")
public class VehicleCommandController {

    private final CommandGateway commandGateway;
    private final QueryGateway queryGateway;

    public VehicleCommandController(CommandGateway commandGateway, QueryGateway queryGateway) {
        this.commandGateway = commandGateway;
        this.queryGateway = queryGateway;
    }

    @PostMapping("/new")
    public VehicleDto createVehicle(@Valid @RequestBody CreateVehicleDto createVehicleDto) {
        String vehicleId = UUID.randomUUID().toString();

        SubscriptionQueryResult<VehicleDto, VehicleDto> queryResult = queryGateway.subscriptionQuery(
                new FindVehicleQuery(vehicleId),
                VehicleDto.class, VehicleDto.class
        );

        var command = CreateVehicleCommand.builder()
                .vehicleId(vehicleId)
                .company(createVehicleDto.getCompany())
                .model(createVehicleDto.getModel())
                .build();

        try {
            commandGateway.sendAndWait(command);
            return queryResult.updates().blockFirst();
        } finally {
            queryResult.close();
        }
    }

    @PostMapping("/assign/{customerId}/{vehicleId}")
    public String assignVehicleToCustomer(
            @Valid @RequestBody AssignVehicleToCustomerDto dto,
            @NotNull @PathVariable String customerId,
            @NotNull @PathVariable String vehicleId) {
        var customerVehicleId = UUID.randomUUID().toString();

        var command = AssignVehicleToCustomerCommand.builder()
                .customerVehicleId(customerVehicleId)
                .customerId(customerId)
                .vehicleId(vehicleId)
                .plateNumber(dto.getPlateNumber())
                .color(dto.getColor())
                .productionYear(dto.getProductionYear())
                .build();

        return commandGateway.sendAndWait(command);
    }

}
