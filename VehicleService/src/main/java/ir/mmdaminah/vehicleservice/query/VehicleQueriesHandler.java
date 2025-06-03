package ir.mmdaminah.vehicleservice.query;

import ir.mmdaminah.vehicleservice.core.dto.VehicleDto;
import ir.mmdaminah.vehicleservice.core.repository.VehicleRepository;
import ir.mmdaminah.vehicleservice.query.queries.FindAllVehiclesQuery;
import ir.mmdaminah.vehicleservice.query.queries.FindCustomerVehiclesQuery;
import ir.mmdaminah.vehicleservice.query.queries.FindVehicleQuery;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class VehicleQueriesHandler {

    private final VehicleRepository vehicleRepository;

    public VehicleQueriesHandler(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    @QueryHandler
    public List<VehicleDto> getVehicles(FindCustomerVehiclesQuery query) {

        // TODO: this is wrong, should filter by customer id
        return vehicleRepository.findAll().stream().map(vehicle -> {
            VehicleDto vehicleDto = new VehicleDto();
            BeanUtils.copyProperties(vehicle, vehicleDto);
            return vehicleDto;
        }).toList();

    }

    @QueryHandler
    public VehicleDto getVehicle(FindVehicleQuery query) {
        var vehicle = vehicleRepository.findById(query.getVehicleId());
        if (vehicle.isEmpty()) {
            throw new RuntimeException("Vehicle with id %s not found".formatted(query.getVehicleId()));
        }
        VehicleDto vehicleDto = new VehicleDto();
        BeanUtils.copyProperties(vehicle.get(), vehicleDto);
        return vehicleDto;
    }

    @QueryHandler
    public List<VehicleDto> findAllVehicles(FindAllVehiclesQuery query) {
        return vehicleRepository.findAll().stream().map(vehicle -> {
            VehicleDto vehicleDto = new VehicleDto();
            BeanUtils.copyProperties(vehicle, vehicleDto);
            return vehicleDto;
        }).toList();
    }

}
