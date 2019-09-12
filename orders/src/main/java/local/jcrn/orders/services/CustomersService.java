package local.jcrn.orders.services;

import local.jcrn.orders.model.Customers;

import java.util.List;

public interface CustomersService
{

    List<Customers> findAll();

    Customers findCustomerById(long id);

    Customers findCustomerByName(String name);

    void delete(long id);

    Customers save(Customers customers);

    Customers update(Customers customers, long id);
}
