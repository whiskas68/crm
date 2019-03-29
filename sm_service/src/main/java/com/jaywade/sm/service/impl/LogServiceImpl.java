package com.jaywade.sm.service.impl;

import com.jaywade.sm.dao.LogDao;
import com.jaywade.sm.entity.Log;
import com.jaywade.sm.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service("logService")
public class LogServiceImpl implements LogService {

    @Autowired
    @Qualifier("logDao")
    private LogDao logDao;

    public void addSystemLog(Log log){
        log.setOprTime(new Date());
        log.setType("system");
        logDao.insert(log);
    }

    public void addLoginLog(Log log){
        log.setOprTime(new Date());
        log.setType("login");
        logDao.insert(log);
    }

    public void addOperationLog(Log log){
        log.setOprTime(new Date());
        log.setType("operation");
        logDao.insert(log);
    }

    public List<Log> getSystemLog(){
        return logDao.selectByType("system");
    }

    public List<Log> getLoginLog(){
        return logDao.selectByType("login");
    }

    public List<Log> getOperationLog(){
        return logDao.selectByType("operation");
    }
}

