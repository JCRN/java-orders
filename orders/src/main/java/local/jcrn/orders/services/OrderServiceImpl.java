package local.jcrn.orders.services;

import local.jcrn.orders.models.Order;
import local.jcrn.orders.repos.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service(value = "orderService")
public class OrderServiceImpl implements OrderService {

    @Autowired
    public OrderRepository ordsrepo;

    @Override
    public List<Order> findAll() {

        List<Order> list = new ArrayList<>();
        ordsrepo.findAll().iterator().forEachRemaining(list::add);
        return list;
    }

    @Override
    public Order findOrderById(long id) {
        return null;
    }

    @Override
    public Order findOrderByName(String name) {
        return null;
    }

    @Override
    public void delete(long id) {

    }

    @Override
    public Order save(Order agent) {
        return null;
    }

    @Override
    public Order update(Order order, long id) {
        return null;
    }
}
