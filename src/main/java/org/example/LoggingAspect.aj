package org.example;

import java.util.Arrays;

public aspect LoggingAspect {

    pointcut allMethods(): execution(* org.example..*(..));

    before(): allMethods() {
        System.out.println("[BEFORE] Метод: " + thisJoinPoint.getSignature() +
                ", args: " + Arrays.toString(thisJoinPoint.getArgs()));
    }

    after() returning(Object result): allMethods() {
        System.out.println("[AFTER RETURNING] Метод: " + thisJoinPoint.getSignature() +
                ", возвращает: " + result);
    }

    after() throwing(Throwable ex): allMethods() {
        System.out.println("[AFTER THROWING] Метод: " + thisJoinPoint.getSignature() +
                ", исключение: " + ex);
    }
}
