package com.lilin.beans;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;


/**
 * 容器的后置处理器
 */
//@Component
public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
		LefCycleVerification lefCycleVerification=(LefCycleVerification)beanFactory.getBean("lefCycleVerification");
		System.out.println("BeanFactoryPostProcessor:"+lefCycleVerification.d+lefCycleVerification.diBean);
		System.out.println("容器的后置处理器，此时bean还没有被实例化"+lefCycleVerification+lefCycleVerification.d);
	}
}
