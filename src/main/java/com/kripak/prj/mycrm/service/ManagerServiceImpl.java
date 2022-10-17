package com.kripak.prj.mycrm.service;

import com.kripak.prj.mycrm.dao.ManagerDAO;
import com.kripak.prj.mycrm.entity.Manager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ManagerServiceImpl implements ManagerService {

    @Autowired
    ManagerDAO managerDAO;

    @Override
    @Transactional
    public List<Manager> getAllManagerList() {
        return managerDAO.getAllManagerList();
    }

    @Override
    @Transactional
    public void saveOrUpdateManager(Manager manager) {
        managerDAO.saveOrUpdateManager(manager);
    }

    @Override
    public Manager getManager(int id) {
        return managerDAO.getManager(id);
    }
}
