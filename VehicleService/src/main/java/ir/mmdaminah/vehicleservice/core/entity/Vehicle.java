package ir.mmdaminah.vehicleservice.core.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "vehicles")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Vehicle {

    @Id
    @Column( name = "vehicle_id", unique = true )
    private String vehicleId;

    private String company;

    private String model;

}
