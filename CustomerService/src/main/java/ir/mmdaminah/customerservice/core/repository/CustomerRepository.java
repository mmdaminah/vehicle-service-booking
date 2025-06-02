package ir.mmdaminah.customerservice.core.repository;

import ir.mmdaminah.customerservice.core.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, String> {
}
