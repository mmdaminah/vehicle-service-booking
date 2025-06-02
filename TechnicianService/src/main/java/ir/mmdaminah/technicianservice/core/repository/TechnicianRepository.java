package ir.mmdaminah.technicianservice.core.repository;

import ir.mmdaminah.technicianservice.core.entity.Technician;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TechnicianRepository extends JpaRepository<Technician, String> {
}
