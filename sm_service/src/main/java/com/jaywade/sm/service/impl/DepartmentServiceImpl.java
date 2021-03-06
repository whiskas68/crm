package com.jaywade.sm.service.impl;


import com.jaywade.sm.dao.DepartmentDao;
import com.jaywade.sm.entity.Department;
import com.jaywade.sm.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("departmentService")
public class DepartmentServiceImpl implements DepartmentService {

    @Resource(name="departmentDao")
    private DepartmentDao departmentDao;

    @Override
    public void add(Department department) {
        departmentDao.insert(department);

    }

    @Override
    public void remove(Integer id) {
        departmentDao.delete(id);

    }

    @Override
    public void edit(Department department) {
        departmentDao.update(department);

    }

    @Override
    public Department get(Integer id) {
        return departmentDao.selectById(id);
    }

    @Override
    public List<Department> getAll() {
        return departmentDao.selectAll();
    }

}
