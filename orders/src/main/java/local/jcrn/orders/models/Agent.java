package local.jcrn.orders.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "agents")
public class Agent {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long agent_code;

    @Column(unique = true, nullable = false)
    private String agent_name;

    private String working_area;
    private double commission;
    private String phone;
    private String country;

    // one agent to many customers
    @OneToMany(mappedBy = "agent", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Customer> customers = new ArrayList<>();

    public Agent() {
    }

    public Agent(String agent_name, String working_area, double commission, String phone, String country) {
        this.agent_name = agent_name;
        this.working_area = working_area;
        this.commission = commission;
        this.phone = phone;
        this.country = country;
    }

    public long getAgent_code() {
        return agent_code;
    }

    public void setAgent_code(long agent_code) {
        this.agent_code = agent_code;
    }

    public String getAgent_name() {
        return agent_name;
    }

    public void setAgent_name(String agent_name) {
        this.agent_name = agent_name;
    }

    public String getWorking_area() {
        return working_area;
    }

    public void setWorking_area(String working_area) {
        this.working_area = working_area;
    }

    public double getCommission() {
        return commission;
    }

    public void setCommission(double commission) {
        this.commission = commission;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }
}
