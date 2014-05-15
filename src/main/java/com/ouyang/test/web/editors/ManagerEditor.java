package com.ouyang.test.web.editors;

import java.beans.PropertyEditorSupport;

import com.ouyang.test.domain.Manager;
import com.ouyang.test.service.dao.ManagerDao;

public class ManagerEditor extends PropertyEditorSupport {

    private ManagerDao managerDao;

    public ManagerEditor(ManagerDao managerDao) {
        this.managerDao = managerDao;
    }

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        long id = Long.parseLong(text);
        Manager manager = managerDao.find(id);
        setValue(manager);
    }
}