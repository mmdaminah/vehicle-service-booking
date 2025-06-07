package ir.mmdaminah.vehicleservice.core.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "customer-vehicle", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"customer_id", "vehicle_id"})
})
@AllArgsConstructor
@NoArgsConstructor
@Data
public class CustomerVehicle {

    @Id
    @Column(name = "customer_vehicle_id")
    private String customerVehicleId;

    @Column(name = "customer_id")
    private String customerId;

    @Column(name = "plate_number")
    private String plateNumber;

    private String color;

    @Column(name = "production_year")
    private Integer productionYear;

    @OneToOne
    @JoinColumn(name = "vehicle_id", referencedColumnName = "vehicle_id")
    private Vehicle vehicle;

}
