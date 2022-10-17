package com.kripak.prj.mycrm.dao;

import com.kripak.prj.mycrm.entity.Manager;

import java.util.List;

public interface ManagerDAO {

    List<Manager> getAllManagerList();

    void saveOrUpdateManager(Manager manager);

    Manager getManager(int id);
}
