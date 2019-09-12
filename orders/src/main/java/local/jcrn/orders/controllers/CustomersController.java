package local.jcrn.orders.controllers;

import local.jcrn.orders.model.Customers;
import local.jcrn.orders.services.CustomersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomersController
{

    @Autowired
    private CustomersService customersService;

    // localhost:2019/customers
    @GetMapping(value = "/customers", produces = {"application/json"})
    public ResponseEntity<?> listAllCustomers()
    {
        List<Customers> customersList = customersService.findAll();
        return new ResponseEntity<>(customersList, HttpStatus.OK);
    }

    @GetMapping(value ="/name/{custname}", produces = {"application/json"})
    public ResponseEntity<?> findCustomerByName(@PathVariable String custname) {
        Customers customers = customersService.findCustomerByName(custname);
        return new ResponseEntity<>(customers, HttpStatus.OK);
    }
}
