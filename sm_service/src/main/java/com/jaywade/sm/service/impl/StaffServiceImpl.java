package com.jaywade.sm.service.impl;

import com.jaywade.sm.dao.StaffDao;
import com.jaywade.sm.entity.Staff;
import com.jaywade.sm.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service("staffService")
public class StaffServiceImpl implements StaffService {
    @Resource(name="staffDao")
    private StaffDao staffDao;

    @Override
    public void add(Staff staff) {
        staff.setPassword("123456");
        staff.setWorkTime(new Date());
        staff.setStatus("normal");
        staffDao.insert(staff);

    }

    @Override
    public void remove(Integer id) {
        staffDao.delete(id);

    }

    @Override
    public void edit(Staff staff) {
        staffDao.update(staff);

    }

    @Override
    public Staff get(Integer id) {
        return staffDao.selectById(id);
    }

    @Override
    public List<Staff> getAll() {
        return staffDao.selectAll();
    }

}
