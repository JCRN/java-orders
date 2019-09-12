package local.jcrn.orders.controllers;

import local.jcrn.orders.model.Orders;
import local.jcrn.orders.services.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrdersController
{

    @Autowired
    private OrdersService ordersService;

    // localhost:2019/agents/agents
    @GetMapping(value = "/orders", produces = {"application/json"})
    public ResponseEntity<?> listAllOrders()
    {
        List<Orders> ordersList = ordersService.findAll();
        return new ResponseEntity<>(ordersList, HttpStatus.OK);
    }
}
