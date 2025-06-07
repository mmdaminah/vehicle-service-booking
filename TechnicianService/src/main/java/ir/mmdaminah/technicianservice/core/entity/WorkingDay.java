package ir.mmdaminah.technicianservice.core.entity;

import ir.mmdaminah.technicianservice.core.data.Day;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigInteger;
import java.util.List;

@Entity
@Table( name = "working_days")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class WorkingDay {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "week_day")
    private Day day;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn( name = "working_time_id")
    private List<WorkingTime> workingTimes;

}
