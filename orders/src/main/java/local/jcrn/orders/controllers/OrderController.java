package local.jcrn.orders.controllers;

import local.jcrn.orders.models.Order;
import local.jcrn.orders.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    // localhost:2019/agents/agents
    @GetMapping(value = "/orders", produces = {"application/json"})
    public ResponseEntity<?> listAllOrders()
    {
        List<Order> orderList = orderService.findAll();
        return new ResponseEntity<>(orderList, HttpStatus.OK);
    }
}
