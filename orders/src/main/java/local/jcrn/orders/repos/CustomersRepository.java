package local.jcrn.orders.repos;

import local.jcrn.orders.model.Customers;
import org.springframework.data.repository.CrudRepository;

public interface CustomersRepository extends CrudRepository<Customers, Long> {
    Customers findCustomerByName(String name);

    Customers findByAgent_Agentcode(long agentid);
}
