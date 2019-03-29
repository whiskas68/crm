package com.jaywade.sm.global;

import com.jaywade.sm.entity.Log;
import com.jaywade.sm.entity.Staff;
import com.jaywade.sm.service.LogService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Component
@Aspect
public class LogAdvice {

    @Autowired
    private LogService logService;
    @After("execution(* com.jaywade.sm.controller.*.*(..)) && !execution(* com.jaywade.sm.controller.SelfController.*(..)) && !execution(* com.jaywade.sm.controller.*.to*(..))")
    public void operationLog(JoinPoint joinPoint){
        Log log = new Log();
        log.setModule(joinPoint.getTarget().getClass().getSimpleName());
        log.setOperation(joinPoint.getSignature().getName());
        HttpServletRequest request =(HttpServletRequest) joinPoint.getArgs()[0];
        HttpSession session = request.getSession();
        Object obj = session.getAttribute("USER");
        Staff staff =(Staff)obj;
        log.setOperator(staff.getAccount());
        log.setResult("successful");
        logService.addOperationLog(log);
    }

    @AfterThrowing(throwing = "e",pointcut = "execution(* com.jaywade.sm.controller.*.*(..)) && !execution(* com.jaywade.sm.controller.SelfController.*(..))")
    public void systemLog(JoinPoint joinPoint,Throwable e){
        Log log = new Log();
        log.setModule(joinPoint.getTarget().getClass().getSimpleName());
        log.setOperator(joinPoint.getSignature().getName());
        HttpServletRequest request =(HttpServletRequest) joinPoint.getArgs()[0];
        HttpSession session = request.getSession();
        Object obj = session.getAttribute("USER");
        Staff staff =(Staff)obj;
        log.setOperator(staff.getAccount());
        log.setResult(e.getClass().getSimpleName());
        logService.addSystemLog(log);

    }

    @After("execution(* com.jaywade.sm.controller.SelfController.login(..))")
    public void loginLog(JoinPoint joinPoint) {
        log(joinPoint);
    }

    @Before("execution(* com.jaywade.sm.controller.SelfController.logout(..)))")
    public void logout(JoinPoint joinPoint) {
        log(joinPoint);
    }

    private void log(JoinPoint joinPoint) {
        Log log = new Log();
        log.setModule(joinPoint.getTarget().getClass().getSimpleName());
        log.setOperator(joinPoint.getSignature().getName());
        HttpServletRequest request =(HttpServletRequest) joinPoint.getArgs()[0];
        HttpSession session = request.getSession();
        Object obj = session.getAttribute("USER");
        if(obj==null){
            log.setOperator(request.getParameter("account"));
            log.setResult("Failed");
        }else{
            Staff staff = (Staff) obj;
            log.setOperator(staff.getAccount());
            log.setResult("Successful");
        }
        logService.addLoginLog(log);
    }

}
