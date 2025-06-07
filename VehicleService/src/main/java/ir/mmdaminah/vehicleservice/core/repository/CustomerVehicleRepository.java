package ir.mmdaminah.vehicleservice.core.repository;

import ir.mmdaminah.vehicleservice.core.entity.CustomerVehicle;
import ir.mmdaminah.vehicleservice.core.entity.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerVehicleRepository extends JpaRepository<CustomerVehicle, String> {
    List<CustomerVehicle> findAllByCustomerId(String customerId);
}