package org.hello.core.aop;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 *
 * @author: hanqiang
 * @Date: 2018年7月19日
 */
@Aspect
@Component
public class LogAspect {
	
	private static final ThreadLocal<Long> threadLocal = new ThreadLocal<Long>() {
		protected Long initialValue() {
			return 0L;
		};
	};

	@Pointcut("execution(public * org.hello.core.service..*.*(..))")
	public void pointCut() {}
	
	@Before("pointCut()")
	public void before(JoinPoint joinPoint) {
		threadLocal.set(System.currentTimeMillis());
		System.out.println(joinPoint.getClass().getName() + " - [INFO] 方法名: " + joinPoint.getSignature().getName() + ", 方法参数: " + Arrays.asList(joinPoint.getArgs()));
	}
	
	@After("pointCut()")
	public void after(JoinPoint joinPoint) {
		System.out.println(joinPoint.getClass().getName() + " - [INFO] 方法名: " + joinPoint.getSignature().getName() + ", 方法耗时: " + (System.currentTimeMillis() - threadLocal.get()) + "ms");
	}
	
	@AfterReturning(value = "pointCut()", returning = "retVal")
	public void afterReturning(JoinPoint joinPoint, Object retVal) {
		System.out.println(joinPoint.getClass().getName() + " - [INFO] 方法名: " + joinPoint.getSignature().getName() + ", 方法返回值: " + retVal);
	}
}
