package com.kripak.prj.mycrm.service;


import com.kripak.prj.mycrm.dao.CustomerOrderDAO;
import com.kripak.prj.mycrm.entity.CustomerOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CustomerOrderServiceImpl implements CustomerOrderService {

    @Autowired
    CustomerOrderDAO customerOrderDAO;

    @Override
    @Transactional // Spring  auto control open and closed transactional
    public List<CustomerOrder> getCustomerOrderList(int stage) {
        return customerOrderDAO.getCustomerOrderList(stage);
    }

    @Override
    @Transactional
    public void saveOrUpdateOrder(CustomerOrder customerOrder) {
        customerOrderDAO.saveOrUpdateOrder(customerOrder);
    }

    @Override
    @Transactional
    public CustomerOrder getCustomerOrder(int id) {
        return customerOrderDAO.getCustomerOrder(id);
    }

    @Override
    @Transactional
    public void setStageOrder(CustomerOrder customerOrder, int stage) {
        customerOrderDAO.setStageOrder(customerOrder, stage);
    }


}
