package com.lilin.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

/**
 * 告诉spring这是一个切面类
 */
@Aspect
public class MyAspects {


	/**
	 * 抽取公共的切入点表达式  可以在本类中使用  也可以在其他类中使用(全限类名)
	 */
	@Pointcut("execution(public * com.lilin.aop.TargetMethod.*(..))")
	public void pointCut() {
	}


	//目标方法之前切入：切入的表达式
	//@Before("public void com.lilin.mwmw.aop.TargetMethod.execute()")  只是指定具体的类中的那个方法
	@Before(value = "pointCut()")   //方法中的所有方法
	public void executeBefore(JoinPoint joinPoint) {
		System.out.println("方法运行之前");
		//获取目标方法的参数
		Object[] args = joinPoint.getArgs();
		//获取目标方法的方法名
		String methodName = joinPoint.getSignature().getName();
	}


	//假定使用的是外部的一个切点  使用外部那个切点的全限类名
	@After(value = "com.lilin.aop.MyAspects.pointCut()")
	public void executeAfter(JoinPoint joinPoint) {
		System.out.println("方法运行之后");
	}


	//当方法正常返回的时候调用
	@AfterReturning(value = "pointCut()")
	public void executeReturning(JoinPoint joinPoint) {
		System.out.println("方法正常返回");
	}

	@AfterThrowing(value = "pointCut()")
	public void executeException(JoinPoint joinPoint) {
		System.out.println("方法报错了");
	}


	/**
	 * 虽然Around功能强大，但通常需要在线程安全的环境下使用。
	 * 因此，如果使用普通的Before、AfterReturing增强方法就可以解决的事情，
	 * 就没有必要使用Around增强处理了。
	 * @param point
	 */
	@Around(value = "pointCut()")
	public void executeArround(ProceedingJoinPoint point) throws Throwable {
		System.out.println("ANNOTATION welcome");
		System.out.println("ANNOTATION 调用类：" + point.getSignature().getDeclaringTypeName());
		System.out.println("ANNOTATION 调用类名" + point.getSignature().getDeclaringType().getSimpleName());
		point.proceed(); //调用目标方法
		System.out.println("ANNOTATION login success");
	}


}
