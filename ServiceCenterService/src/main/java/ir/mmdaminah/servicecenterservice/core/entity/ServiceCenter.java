package ir.mmdaminah.servicecenterservice.core.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "service-centers")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ServiceCenter {

    @Id
    @Column(name = "service-center-id")
    private String serviceCenterId;

    private String name;
    private String province;
    private String city;
    private String address;



}
