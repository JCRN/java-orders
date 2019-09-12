package local.jcrn.orders.services;

import local.jcrn.orders.model.Orders;

import java.util.List;

public interface OrdersService
{
    List<Orders> findAll();

    Orders findOrderById(long id);

    Orders findOrderByName(String name);

    void delete(long id);

    Orders save(Orders agent);

    Orders update(Orders orders, long id);
}
