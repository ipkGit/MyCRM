package com.kripak.prj.mycrm.entity;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "managers")
public class Manager {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "manager_id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surName;

    @Column(name = "salary")
    private int salary;

    @OneToMany(mappedBy = "customer")
    private List<CustomerOrder> orderList;


    //Constructor's
    public Manager() {
    }

    public Manager(String name, String surName, int salary) {
        this.name = name;
        this.surName = surName;
        this.salary = salary;
    }

    //add Manager to Order and Order to Manager's orderList too
    public void addManagerToOrder (CustomerOrder customerOrder) {
        if(orderList == null) {
            orderList = new ArrayList<>();
        }
        orderList.add(customerOrder);

        customerOrder.setManager(this);
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

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public List<CustomerOrder> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<CustomerOrder> orderList) {
        this.orderList = orderList;
    }


}
