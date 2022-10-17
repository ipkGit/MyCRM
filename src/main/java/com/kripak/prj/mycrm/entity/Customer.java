package com.kripak.prj.mycrm.entity;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "customers")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "email")
    private String email;

    @OneToMany(mappedBy = "customer")
    private List<CustomerOrder> orderList;

    //Constructor's
    public Customer() {
    }

    public Customer(String name, String surname, String email) {
        this.name = name;
        this.surname = surname;
        this.email = email;
    }

    //Add Customer to Order and Order to Customer's orderList too
    public void addCustomerToOrder (CustomerOrder customerOrder) {
        if(orderList == null) {
            orderList = new ArrayList<>();
        }
        orderList.add(customerOrder);

        customerOrder.setCustomer(this);
    }

    //Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<CustomerOrder> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<CustomerOrder> orderList) {
        this.orderList = orderList;
    }
}
