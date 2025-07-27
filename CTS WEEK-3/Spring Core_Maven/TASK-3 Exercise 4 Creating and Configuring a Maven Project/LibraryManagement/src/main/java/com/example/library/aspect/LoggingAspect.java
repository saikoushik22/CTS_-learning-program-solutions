 
package com.example.library.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class LoggingAspect {

    @Before("execution(* com.example.library.service.*.*(..))")
    public void beforeServiceMethod(JoinPoint jp) {
        System.out.println("[LOG] Entering: " + jp.getSignature());
    }

    @AfterReturning("execution(* com.example.library.service.*.*(..))")
    public void afterServiceMethod(JoinPoint jp) {
        System.out.println("[LOG] Exiting : " + jp.getSignature());
    }
}
