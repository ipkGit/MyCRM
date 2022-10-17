package com.kripak.prj.mycrm.dao;

import com.kripak.prj.mycrm.entity.CustomerOrder;

import java.util.List;

public interface CustomerOrderDAO {

    List<CustomerOrder> getCustomerOrderList(int stage);

    void saveOrUpdateOrder(CustomerOrder customerOrder);

    CustomerOrder getCustomerOrder(int id);

    void setStageOrder(CustomerOrder customerOrder, int stage);
}
