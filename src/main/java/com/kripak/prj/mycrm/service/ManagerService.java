package com.kripak.prj.mycrm.service;

import com.kripak.prj.mycrm.entity.Manager;

import java.util.List;

public interface ManagerService {

    List<Manager> getAllManagerList();

    void saveOrUpdateManager(Manager manager);

    Manager getManager(int id);
}
