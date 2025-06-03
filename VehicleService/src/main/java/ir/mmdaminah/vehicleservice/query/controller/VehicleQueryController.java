package ir.mmdaminah.vehicleservice.query.controller;

import ir.mmdaminah.vehicleservice.core.dto.VehicleDto;
import ir.mmdaminah.vehicleservice.query.queries.FindAllVehiclesQuery;
import ir.mmdaminah.vehicleservice.query.queries.FindCustomerVehiclesQuery;
import jakarta.validation.constraints.NotNull;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/vehicles")
public class VehicleQueryController {

    private final QueryGateway queryGateway;

    public VehicleQueryController(QueryGateway queryGateway) {
        this.queryGateway = queryGateway;
    }

    @GetMapping
    public List<VehicleDto> findAll() {
        return queryGateway.query(
                new FindAllVehiclesQuery(),
                ResponseTypes.multipleInstancesOf(VehicleDto.class)
        ).join();
    }

    @GetMapping("/{customer-id}")
    public List<VehicleDto> getCustomerVehicles(@NotNull @PathVariable("customer-id") String customerId) {
        return queryGateway.query(
                new FindCustomerVehiclesQuery(customerId),
                ResponseTypes.multipleInstancesOf(VehicleDto.class)
        ).join();
    }



}
