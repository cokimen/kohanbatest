package dimski.py.drf.order.repos;

import dimski.py.drf.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CustomerJPARepo extends JpaRepository<Customer, UUID> {
}
