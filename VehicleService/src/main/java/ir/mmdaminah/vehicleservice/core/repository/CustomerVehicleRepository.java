package ir.mmdaminah.vehicleservice.core.repository;

import ir.mmdaminah.vehicleservice.core.entity.CustomerVehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerVehicleRepository extends JpaRepository<CustomerVehicle, String> {
}
