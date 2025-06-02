package ir.mmdaminah.servicecenterservice.core.repository;

import ir.mmdaminah.servicecenterservice.core.entity.ServiceCenter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServiceCenterRepository extends JpaRepository<ServiceCenter, String> {
}
