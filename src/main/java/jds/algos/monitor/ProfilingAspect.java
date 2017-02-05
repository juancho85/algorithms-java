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
            System.out.println(pjp.getSignature().getName());
            return pjp.proceed();
        } finally {
            System.out.println(System.nanoTime() - start + " ns");
        }
    }


    @Pointcut("execution(* jds.algos.primes.*.*(..))")
    public void methodsToBeProfiled(){}

}
