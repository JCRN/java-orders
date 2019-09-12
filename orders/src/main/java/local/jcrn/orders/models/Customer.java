package local.jcrn.orders.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "customers")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long cust_code;

    @Column(unique = true, nullable = false)
    private String cust_name;

    private String cust_city;
    private String working_area;
    private String cust_country;
    private String grade;
    private double opening_amt;
    private double receive_amt;
    private double payment_amt;
    private double outstanding_amt;
    private String phone;

    // many customers to one agent
    @ManyToOne
    @JoinColumn(name = "agent_code", nullable = false)
    private long agent;

    // one customer to many orders
    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Order> orders = new ArrayList<>();

    public Customer() {
    }

    public Customer(String cust_name, String cust_city, String working_area, String cust_country, String grade, double opening_amt, double receive_amt, double payment_amt, double outstanding_amt, String phone, long agent) {
        this.cust_name = cust_name;
        this.cust_city = cust_city;
        this.working_area = working_area;
        this.cust_country = cust_country;
        this.grade = grade;
        this.opening_amt = opening_amt;
        this.receive_amt = receive_amt;
        this.payment_amt = payment_amt;
        this.outstanding_amt = outstanding_amt;
        this.phone = phone;
        this.agent = agent;
    }

    public long getCust_code() {
        return cust_code;
    }

    public void setCust_code(long cust_code) {
        this.cust_code = cust_code;
    }

    public String getCust_name() {
        return cust_name;
    }

    public void setCust_name(String cust_name) {
        this.cust_name = cust_name;
    }

    public String getCust_city() {
        return cust_city;
    }

    public void setCust_city(String cust_city) {
        this.cust_city = cust_city;
    }

    public String getWorking_area() {
        return working_area;
    }

    public void setWorking_area(String working_area) {
        this.working_area = working_area;
    }

    public String getCust_country() {
        return cust_country;
    }

    public void setCust_country(String cust_country) {
        this.cust_country = cust_country;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public double getOpening_amt() {
        return opening_amt;
    }

    public void setOpening_amt(double opening_amt) {
        this.opening_amt = opening_amt;
    }

    public double getReceive_amt() {
        return receive_amt;
    }

    public void setReceive_amt(double receive_amt) {
        this.receive_amt = receive_amt;
    }

    public double getPayment_amt() {
        return payment_amt;
    }

    public void setPayment_amt(double payment_amt) {
        this.payment_amt = payment_amt;
    }

    public double getOutstanding_amt() {
        return outstanding_amt;
    }

    public void setOutstanding_amt(double outstanding_amt) {
        this.outstanding_amt = outstanding_amt;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public long getAgent() {
        return agent;
    }

    public void setAgent(long agent) {
        this.agent = agent;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }
}
