package ir.mmdaminah.technicianservice.command.controller;

import ir.mmdaminah.technicianservice.command.commands.CreateTechnicianCommand;
import ir.mmdaminah.technicianservice.core.dto.CreateTechnicianDto;
import jakarta.validation.Valid;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/technician")
public class TechnicianCommandController {

    @Autowired
    CommandGateway commandGateway;

    @PostMapping
    public String createTechnician(@Valid @RequestBody CreateTechnicianDto dto) {
        var command = CreateTechnicianCommand.builder()
                .technicianId(UUID.randomUUID().toString())
                .firstName(dto.getFirstName())
                .lastName(dto.getLastName())
                .workingDays(dto.getWorkingDays())
                .build();

        String result = commandGateway.sendAndWait(command);

        return result;
    }

}
