package com.jaywade.sm.service;

import com.jaywade.sm.entity.Staff;

public interface SelfService {
    Staff login(String account,String password);
    void changePassword(Integer id,String password);
}
