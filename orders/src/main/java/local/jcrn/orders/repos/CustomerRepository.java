package local.jcrn.orders.repos;

import local.jcrn.orders.models.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer, Long> {
}
