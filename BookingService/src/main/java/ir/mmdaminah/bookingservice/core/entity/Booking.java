package ir.mmdaminah.bookingservice.core.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "bookings")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Booking {

    @Id
    @Column(name = "booking-id",unique = true, nullable = false)
    private String bookingId;

    @Column(name = "service-id")
    private String serviceId;

    @Column(name = "technician-id")
    private String technicianId;

    @Column(name = "customer-id")
    private String customerId;

     @Column(name= "start-hour")
    private Integer startHour;

    @Column(name = "start-minute")
    private Integer startMinute;

}
