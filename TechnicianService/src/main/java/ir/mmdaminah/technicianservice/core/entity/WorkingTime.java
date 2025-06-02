package ir.mmdaminah.technicianservice.core.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigInteger;

@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
@Data
public class WorkingTime {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private BigInteger id;

    @Column(name= "start-hour")
    private Integer startHour;

    @Column(name = "start-minute")
    private Integer startMinute;

    @Column(name = "end-hour")
    private Integer endHour;

    @Column(name = "end-minute")
    private Integer endMinute;

}
