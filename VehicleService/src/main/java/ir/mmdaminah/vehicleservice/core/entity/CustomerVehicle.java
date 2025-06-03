package ir.mmdaminah.vehicleservice.core.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table( name = "customer-vehicle")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class CustomerVehicle {

    @Id
    @Column( name = "customer_vhicle_id")
    private String customerVehicleId;

    @Column( name = "customer_id")
    private String customerId;

    @Column( name = "vehicle_id")
    private String vehicleId;

    @Column( name = "plate_number")
    private String plateNumber;

}
