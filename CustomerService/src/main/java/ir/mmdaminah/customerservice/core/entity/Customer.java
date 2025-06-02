package ir.mmdaminah.customerservice.core.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "customers")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer {

    @Id
    @Column(name = "customer-id", unique = true)
    private String customerId;

    @Column(name = "first-name")
    private String firstName;

    @Column(name = "last-name")
    private String lastName;

}
