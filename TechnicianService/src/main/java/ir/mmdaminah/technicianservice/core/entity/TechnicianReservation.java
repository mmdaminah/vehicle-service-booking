package ir.mmdaminah.technicianservice.core.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name = "technician_reservation")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TechnicianReservation {

    @Id
    @Column(name = "reservation_id", unique = true, nullable = false)
    private String reservationId;

    @Column(name = "technician_id")
    private String technicianId;

    @Column(name = "booking_id")
    private String bookingId;

    @Column(name = "service_id")
    private String serviceId;

    @Column(name = "customer_id")
    private String customerId;

    @Column(name = "start-time")
    private String startTime;

    private Date date;

}
