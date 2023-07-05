package dimski.py.drf.order.repos;

import dimski.py.drf.models.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface OrderJPARepo extends JpaRepository<Order, UUID> {
}
