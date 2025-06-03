package ir.mmdaminah.bookingservice.core.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name = "bookings")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Booking {

    @Id
    @Column(name = "booking_id",unique = true, nullable = false)
    private String bookingId;

    @Column(name = "service_id")
    private String serviceId;

    @Column(name = "technician_id")
    private String technicianId;

    @Column(name = "customer_id")
    private String customerId;

     @Column(name= "start_hour")
    private Integer startHour;

    @Column(name = "start_minute")
    private Integer startMinute;

    private Date date;

}
