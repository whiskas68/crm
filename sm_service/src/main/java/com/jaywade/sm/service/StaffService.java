package com.jaywade.sm.service;

import com.jaywade.sm.entity.Staff;
import com.jaywade.sm.entity.Department;

import java.util.List;

public interface StaffService {
    void add(Staff staff);
    void remove(Integer id);
    void edit(Staff staff);
    Staff get(Integer id);
    List<Staff> getAll();
}
