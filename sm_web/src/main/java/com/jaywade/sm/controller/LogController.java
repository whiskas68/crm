package com.jaywade.sm.controller;

import com.jaywade.sm.entity.Log;
import com.jaywade.sm.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller("logController")
public class LogController {

    @Autowired
    @Qualifier("logService")
    private LogService logService;

    public void operationLog(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Log> list =logService.getOperationLog();
        request.setAttribute("List",list);
        request.setAttribute("TYPE","operate");
        request.getRequestDispatcher("../log_list.jsp").forward(request,response);
    }

    public void loginLog(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Log> list =logService.getOperationLog();
        request.setAttribute("List",list);
        request.setAttribute("TYPE","login");
        request.getRequestDispatcher("../log_list.jsp").forward(request,response);
    }

    public void systemLog(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Log> list =logService.getOperationLog();
        request.setAttribute("List",list);
        request.setAttribute("TYPE","system");
        request.getRequestDispatcher("../log_list.jsp").forward(request,response);
    }
}
