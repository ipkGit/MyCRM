package com.kripak.prj.mycrm.dao;

import com.kripak.prj.mycrm.entity.CustomerOrder;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository //Mark for registration this component in Spring Container
public class CustomerOrderDAOImpl implements CustomerOrderDAO {

    @Autowired //Create bean sessionFactory from applicationContext
    private SessionFactory sessionFactory;

    /*
    передает список всех заказов из БД
    transmits list of all orders from BD
     */
    @Override
    public List<CustomerOrder> getCustomerOrderList(int stage) {
        Session session = sessionFactory.getCurrentSession();

        List<CustomerOrder> customerOrderList = session.createQuery("from CustomerOrder where stage =" + stage, CustomerOrder.class)
                .getResultList();

        return customerOrderList;
    }


    /*
    Сохранить или обновить заказ в БД
    Save or Update order in BD
     */
    @Override
    public void saveOrUpdateOrder(CustomerOrder customerOrder) {

        Session session = sessionFactory.getCurrentSession();

        session.saveOrUpdate(customerOrder);
    }

    /*
    получить данные заказа по id
    Get orders details by id
     */
    @Override
    public CustomerOrder getCustomerOrder(int id) {
        Session session = sessionFactory.getCurrentSession();

        CustomerOrder customerOrder = session.get(CustomerOrder.class, id);

        return customerOrder;

    }

    @Override
    public void setStageOrder(CustomerOrder customerOrder, int stage) {
        Session session = sessionFactory.getCurrentSession();
        stage = stage + customerOrder.getStage();
        customerOrder.setStage(stage);
        session.saveOrUpdate(customerOrder);
    }


}
