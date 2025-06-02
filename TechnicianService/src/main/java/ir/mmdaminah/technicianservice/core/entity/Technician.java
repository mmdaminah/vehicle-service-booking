package ir.mmdaminah.technicianservice.core.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "technicians")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Technician {

    @Id
    @Column(name = "technician-id")
    private String technicianId;

    @Column(name = "first-name")
    private String firstName;

    @Column(name = "last-name")
    private String lastName;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "technician-id")
    private List<WorkingDay> workingDays;

}
