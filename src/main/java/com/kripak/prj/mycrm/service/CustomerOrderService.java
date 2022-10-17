package com.kripak.prj.mycrm.service;

import com.kripak.prj.mycrm.entity.CustomerOrder;

import java.util.List;

public interface CustomerOrderService {

    List<CustomerOrder> getCustomerOrderList (int stage);

    void saveOrUpdateOrder(CustomerOrder customerOrder);

    CustomerOrder getCustomerOrder(int id);

    void setStageOrder(CustomerOrder customerOrder, int stage);
}
