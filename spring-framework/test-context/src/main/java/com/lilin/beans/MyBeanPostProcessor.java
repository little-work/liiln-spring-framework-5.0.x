package com.lilin.beans;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;


/**
 * bean的后置处理器，实现这个方法是对所有的bean进行处理  需要判断bean的类型 在init方式之前之后执行
 */
@Component
public class MyBeanPostProcessor implements BeanPostProcessor {


	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
if(beanName.equals("lefCycleVerification"))
		System.out.println("postProcessBeforeInitialization"+beanName);

		return bean;
	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		if(beanName.equals("lefCycleVerification"))
		System.out.println("postProcessAfterInitialization"+beanName);

		return bean;
	}
}
