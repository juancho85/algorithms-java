package jds.algos.monitor;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ProfilingAspect {

    @Around("methodsToBeProfiled()")
    public Object profile(ProceedingJoinPoint pjp) throws Throwable {
        long start = System.nanoTime();
        try {
            System.out.println("<------------------------------------");
            System.out.println(pjp.getSignature().getName() + " Start");
            return pjp.proceed();
        } finally {
            System.out.println((System.nanoTime() - start) + " ns");
            System.out.println("------------------------------------>");
        }
    }


    @Pointcut("execution(* jds.algos.*.*.*(..))")
    public void methodsToBeProfiled(){}

}
