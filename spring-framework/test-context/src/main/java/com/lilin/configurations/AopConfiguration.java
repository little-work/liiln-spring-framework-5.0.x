package com.lilin.configurations;


import com.lilin.aop.MyAspects;
import com.lilin.aop.TargetMethod;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
@ComponentScan(value = "com.lilin.aop")
public class AopConfiguration {


	@Bean("targetMethod")
	public TargetMethod getTargetMethod(){
		return new TargetMethod();
	}


	@Bean("myAspects")
	public MyAspects getAspects(){
		return new MyAspects();
	}
}
