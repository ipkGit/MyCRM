package com.kripak.prj.mycrm.dao;


import com.kripak.prj.mycrm.entity.Manager;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ManagerDAOImpl implements ManagerDAO {

    @Autowired //Create bean sessionFactory from applicationContext
    private SessionFactory sessionFactory;
    @Override
    public List<Manager> getAllManagerList() {
        Session session = sessionFactory.getCurrentSession();

        List<Manager> managerList = session.createQuery("from Manager ", Manager.class).getResultList();

        return managerList;
    }

    @Override
    public void saveOrUpdateManager(Manager manager) {

        Session session = sessionFactory.getCurrentSession();

        session.saveOrUpdate(manager);
    }

    @Override
    public Manager getManager(int id) {
        Session session = sessionFactory.getCurrentSession();
        Manager manager = session.get(Manager.class, id);
        return manager;
    }
}
