package com.lilin;

import com.lilin.aop.TargetMethod;
import com.lilin.configurations.AopConfiguration;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AopTest {


	public static void main(String[] args) {
		AnnotationConfigApplicationContext aca =
				new AnnotationConfigApplicationContext(AopConfiguration.class);
		TargetMethod targetMethod=(TargetMethod)aca.getBean("targetMethod");
		targetMethod.execute();
	}

}
