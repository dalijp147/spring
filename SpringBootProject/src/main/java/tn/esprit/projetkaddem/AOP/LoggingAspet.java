package tn.esprit.projetkaddem.AOP;


import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
public class LoggingAspet {

    @After("execution(* tn.esprit.projetkaddem.Service.*.save*(..))")
    public void logMethodEntry(JoinPoint joinPoint) {
        String name = joinPoint.getSignature().getName();
        log.info("Ajout effectué " + name + " .");
    }

    @Before("execution(* tn.esprit.projetkaddem.Service.*.save*(..))")
    public void beforeMethod(JoinPoint joinPoint) {
        String name = joinPoint.getSignature().getName();
        log.info("Methode " + name + " lancée.");
    }




    @Around("execution(* tn.esprit.projetkaddem.Service.*.save*(..))")
    public Object aroundMethode(ProceedingJoinPoint pjp) throws Throwable {
        long start = System.currentTimeMillis();
        Object obj = pjp.proceed();
        long elapsedTime = System.currentTimeMillis() - start;
        log.info("Durée d'execution de cette methode est : " + elapsedTime + " ms.");
        return obj;
    }

}
