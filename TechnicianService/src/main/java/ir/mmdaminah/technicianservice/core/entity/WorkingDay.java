package ir.mmdaminah.technicianservice.core.entity;

import ir.mmdaminah.technicianservice.core.data.Day;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigInteger;
import java.util.List;

@Entity
@Table( name = "working-days")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class WorkingDay {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private BigInteger id;

    @Enumerated(EnumType.STRING)
    private Day day;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "day-id")
    private List<WorkingTime> workingTimes;

}
