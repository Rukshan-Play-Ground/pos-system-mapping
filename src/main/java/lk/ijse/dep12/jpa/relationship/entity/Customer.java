package lk.ijse.dep12.jpa.relationship.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Table(name = "customer")

public class Customer implements Serializable {
    @Id
    private String id;
    private String name;
    private String address;
    @OneToMany(mappedBy = "customer", cascade = {CascadeType.PERSIST,CascadeType.DETACH})
    @Setter(AccessLevel.NONE)
    private List<Contact> contacts = new ArrayList<>();

    @OneToMany(mappedBy = "customer",cascade = {CascadeType.PERSIST,CascadeType.DETACH})
    @Setter(AccessLevel.NONE)
    private List<Order> orders = new ArrayList<>();


    public Customer(String id, String name, String address, List<Order> orders) {
        if (orders != null && !orders.isEmpty()) {
            orders.stream().filter(order -> order.getCustomer()==null).
                    forEach(order -> order.setCustomer(this));
        }

        if (orders != null && !orders.isEmpty()) {
            orders.forEach(order -> {
                if (order.getCustomer() !=this)
                    throw new IllegalStateException("An Order:%sOrder is already associated with another customer".
                            formatted(order.getId()));
            });
        }

        this.id = id;
        this.name = name;
        this.address = address;
        this.orders = orders;
    }

    public Customer(String address, String name, String id) {
        this.address = address;
        this.name = name;
        this.id = id;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "address='" + address + '\'' +
                ", name='" + name + '\'' +
                ", id='" + id + '\'' +
                '}';
    }
}
