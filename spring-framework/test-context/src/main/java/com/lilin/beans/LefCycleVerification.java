package com.lilin.beans;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class LefCycleVerification implements BeanNameAware, BeanFactoryAware,
		ApplicationContextAware, InitializingBean {

	@Autowired
	public DIBean diBean;


	public   int d=232212;

	private String name="李林";

	public LefCycleVerification(String name) {
		System.out.println("有参构造方法");
		this.name = name;
	}

	public LefCycleVerification() {
		System.out.println("无参构造方法");
	}

	public String getName() {
		System.out.println("调用get方法");
		return name;
	}

	public void setName(String name) {
		System.out.println("调用set方法");
		this.name = name;
	}

	@Override
	public String toString() {
		return "LefCycleVerification{" +
				"name='" + name + '\'' +
				'}';
	}


	/**
	 * BeanNameAware
	 *
	 * @param name the name of the bean in the factory.
	 *             Note that this name is the actual bean name used in the factory, which may
	 *             differ from the originally specified name: in particular for inner bean
	 *             names, the actual bean name might have been made unique through appending
	 *             "#..." suffixes. Use the {@link BeanFactoryUtils#originalBeanName(String)}
	 */
	@Override
	public void setBeanName(String name) {
		System.out.println("BeanNameAware..." + name);
	}


	/**
	 * BeanFactoryAware
	 *
	 * @param beanFactory owning BeanFactory (never {@code null}).
	 *                    The bean can immediately call methods on the factory.
	 * @throws BeansException
	 */
	@Override
	public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
		LefCycleVerification lefCycleVerification=(LefCycleVerification)beanFactory.getBean("lefCycleVerification");
		System.out.println("注入的bean："+lefCycleVerification.diBean);
		System.out.println("lefCycleVerification其中的一个属性"+lefCycleVerification.d);
		System.out.println("LefCycleVerification.setBeanFactory invoke:" +
				beanFactory.containsBean("lefCycleVerification"));

	}

	/**
	 * ApplicationContextAware
	 *
	 * @param applicationContext the ApplicationContext object to be used by this object
	 * @throws BeansException
	 */
	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		System.out.println("ApplicationContextAware:" + applicationContext.getBeanDefinitionCount());
		LefCycleVerification lefCycleVerification=(LefCycleVerification)applicationContext.getBean("lefCycleVerification");
		System.out.println("注入的bean："+lefCycleVerification.diBean);
	}

	// 自定义初始化方法
	@PostConstruct
	public void springPostConstruct() {
		System.out.println("@PostConstruct");
	}

	/**
	 * InitializingBean
	 *
	 * @throws Exception
	 */
	@Override
	public void afterPropertiesSet() throws Exception {
		this.d=11111;
		System.out.println("afterPropertiesSet");
	}
}
