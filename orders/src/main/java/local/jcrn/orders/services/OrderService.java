package local.jcrn.orders.services;

import local.jcrn.orders.models.Order;

import java.util.List;

public interface OrderService {
    List<Order> findAll();

    Order findOrderById(long id);

    Order findOrderByName(String name);

    void delete(long id);

    Order save(Order agent);

    Order update(Order order, long id);
}
