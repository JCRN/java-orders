package local.jcrn.orders.services;

import local.jcrn.orders.model.Customers;
import local.jcrn.orders.model.Orders;
import local.jcrn.orders.repos.CustomersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Transactional
@Service(value = "customersService")
public class CustomersServiceImpl implements CustomersService
{

    @Autowired
    private CustomersRepository custrepos;

    @Autowired
    private AgentsService agentsService;

    @Override
    public List<Customers> findAll() {
        List<Customers> list = new ArrayList<>();
        custrepos.findAll().iterator().forEachRemaining(list::add);
        return list;
    }

    @Override
    public Customers findCustomerById(long id) throws EntityNotFoundException {
        return custrepos.findById(id).orElseThrow(() -> new EntityNotFoundException(Long.toString(id)));
    }

    @Override
    public Customers findCustomerByName(String name) {
        Customers customer = custrepos.findCustomerByName(name);

        if (customer == null) {
            throw new EntityNotFoundException("Customer " + name + " not found!");
        }
        return customer;
    }

    @Transactional
    @Override
    public void delete(long id)
    {
        if (custrepos.findById(id).isPresent())
        {
            custrepos.deleteById(id);
        }
        else
        {
            throw new EntityNotFoundException(Long.toString(id));
        }
    }

    @Transactional
    @Override
    public Customers save(Customers customers) {
        Customers newCustomer = new Customers();

        newCustomer.setCustname(customers.getCustname());
        newCustomer.setCustcity(customers.getCustcity());
        newCustomer.setWorkingarea(customers.getWorkingarea());
        newCustomer.setCustcountry(customers.getCustcountry());
        newCustomer.setGrade(customers.getGrade());
        newCustomer.setOpeningamt(customers.getOpeningamt());
        newCustomer.setReceiveamt(customers.getReceiveamt());
        newCustomer.setPaymentamt(customers.getPaymentamt());
        newCustomer.setOutstandingamt(customers.getOutstandingamt());
        newCustomer.setPhone(customers.getPhone());
        newCustomer.setAgent(customers.getAgent());

        for (Orders o : customers.getOrders()) {
            newCustomer.getOrders().add(new Orders(o.getOrdamount(), o.getAdvanceamount(),
                    newCustomer, o.getOrddescription()));
        }

        return custrepos.save(newCustomer);
    }

    @Transactional
    @Override
    public Customers update(Customers customers, long id) {

        Customers customer = custrepos.findById(id).orElseThrow(() -> new EntityNotFoundException(Long.toString(id)));

        if (customer.getCustname() != null)
        {
            customer.setCustname(customer.getCustname());
        }

        if (customer.getCustname() != null)
        {
            customer.setCustcity(customer.getCustcity());
        }

        if (customer.getWorkingarea() != null)
        {
            customer.setWorkingarea(customer.getWorkingarea());
        }

        if (customer.getCustcountry() != null)
        {
            customer.setCustcountry(customer.getCustcountry());
        }

        if (customer.getGrade() != null)
        {
            customer.setGrade(customer.getGrade());
        }

        if (customer.getOpeningamt()!= 0)
        {
            customer.setOpeningamt(customer.getOpeningamt());
        }

        if (customer.getReceiveamt() != 0)
        {
            customer.setReceiveamt(customer.getReceiveamt());
        }

        if (customer.getPaymentamt() != 0)
        {
            customer.setPaymentamt(customer.getPaymentamt());
        }

        if (customer.getOutstandingamt() != 0)
        {
            customer.setOutstandingamt(customer.getOutstandingamt());
        }

        if (customer.getPhone() != null)
        {
            customer.setPhone(customer.getPhone());
        }

        if (customer.getAgent() !=null)
        {
            customer.setAgent(customer.getAgent());
        }

        // adds new orders
        if (customer.getOrders().size() > 0)
        {
            for (Orders o : customer.getOrders())
            {
                customer.getOrders().add(new Orders(o.getOrdamount(), o.getAdvanceamount(), customer,
                        o.getOrddescription()));
            }
        }

        return custrepos.save(customer);
    }


}
