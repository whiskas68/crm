package com.jaywade.sm.service.impl;

import com.jaywade.sm.dao.SelfDao;
import com.jaywade.sm.dao.StaffDao;
import com.jaywade.sm.entity.Staff;
import com.jaywade.sm.service.SelfService;
import com.jaywade.sm.service.StaffService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service("staffService")
public class SelfServiceImpl implements SelfService {

    @Resource(name="selfDao")
    private SelfDao selfDao;

    @Resource(name="staffDao")
    private StaffDao staffDao;

    public Staff login(String account, String password){
        Staff staff = selfDao.selectByAccount(account);
        if(staff==null) return null;
        if(staff.getPassword().equals(password)) return staff;
        return null;
    }

    public void changePassword(Integer id,String password){
        Staff staff = staffDao.selectById(id);
        staff.setPassword(password);
        staffDao.update(staff);
    }

}
