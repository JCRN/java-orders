package local.jcrn.orders.controllers;

import local.jcrn.orders.models.Customer;
import local.jcrn.orders.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    // localhost:2019/agents/agents
    @GetMapping(value = "/customers", produces = {"application/json"})
    public ResponseEntity<?> listAllCustomers()
    {
        List<Customer> customersList = customerService.findAll();
        return new ResponseEntity<>(customersList, HttpStatus.OK);
    }
}
