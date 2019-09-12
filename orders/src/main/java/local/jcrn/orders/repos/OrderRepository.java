package local.jcrn.orders.repos;

import local.jcrn.orders.models.Order;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<Order, Long> {
}
