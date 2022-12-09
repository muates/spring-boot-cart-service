package com.bilgeadamboost.springbootcartservice.config;

import com.bilgeadamboost.springbootcartservice.exception.GlobalException;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.server.ResponseStatusException;

@Aspect
@Configuration
public class AspectConfig {

    private final Logger log = LoggerFactory.getLogger(AspectConfig.class);

    @Around(value = "execution(* com.bilgeadamboost.springbootcartservice.service.impl.*.*(..))")
    public Object handler(ProceedingJoinPoint joinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();

        try {
            Object obj = joinPoint.proceed();
            long timeTaken = System.currentTimeMillis() - startTime;
            log.info("Time taken by {} is {}", joinPoint, timeTaken);
            return obj;
        } catch (GlobalException e) {
            log.error("Exception message {}", e.getMessage());
            log.error("Exception status {}", e.getStatus());
            throw new ResponseStatusException(e.getStatus(), e.getMessage());
        }
    }

    /*
        one many address member
        limit 3

        1. getAll .filter member ->
        2. query native
     */
}
