package local.jcrn.orders.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long ord_num;

    private double ord_amount;
    private double advance_amount;
    private String ord_description;

    // many orders to one customer
    @ManyToOne
    @JoinColumn(name = "cust_code", nullable = false)
    private long customer;

    public Order() {
    }

    public Order(double ord_amount, double advance_amount, String ord_description, long customer) {
        this.ord_amount = ord_amount;
        this.advance_amount = advance_amount;
        this.ord_description = ord_description;
        this.customer = customer;
    }

    public long getOrd_num() {
        return ord_num;
    }

    public void setOrd_num(long ord_num) {
        this.ord_num = ord_num;
    }

    public double getOrd_amount() {
        return ord_amount;
    }

    public void setOrd_amount(double ord_amount) {
        this.ord_amount = ord_amount;
    }

    public double getAdvance_amount() {
        return advance_amount;
    }

    public void setAdvance_amount(double advance_amount) {
        this.advance_amount = advance_amount;
    }

    public String getOrd_description() {
        return ord_description;
    }

    public void setOrd_description(String ord_description) {
        this.ord_description = ord_description;
    }

    public long getCustomer() {
        return customer;
    }

    public void setCustomer(long customer) {
        this.customer = customer;
    }
}
