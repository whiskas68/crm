package com.jaywade.sm.dao;

import com.jaywade.sm.entity.Staff;

import java.util.List;

public interface StaffDao {
    void insert(Staff staff);
    void delete(Integer id);
    void update(Staff staff);
    Staff selectById(Integer id);
    List<Staff> selectAll();
}
