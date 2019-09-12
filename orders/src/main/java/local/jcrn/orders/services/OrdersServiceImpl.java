package local.jcrn.orders.services;

import local.jcrn.orders.model.Orders;
import local.jcrn.orders.repos.OrdersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service(value = "ordersService")
public class OrdersServiceImpl implements OrdersService
{

    @Autowired
    public OrdersRepository ordersrepos;

    @Override
    public List<Orders> findAll() {

        List<Orders> list = new ArrayList<>();
        ordersrepos.findAll().iterator().forEachRemaining(list::add);
        return list;
    }

    @Override
    public Orders findOrderById(long id) {
        return null;
    }

    @Override
    public Orders findOrderByName(String name) {
        return null;
    }

    @Override
    public void delete(long id) {

    }

    @Override
    public Orders save(Orders orders) {
        Orders newOrders = new Orders();

        newOrders.setAdvanceamount(orders.getAdvanceamount());
        newOrders.setCustomer(orders.getCustomer());
        newOrders.setOrdamount(orders.getOrdamount());

        return ordersrepos.save(newOrders);
    }

    @Override
    public Orders update(Orders orders, long id) {
        return null;
    }
}
