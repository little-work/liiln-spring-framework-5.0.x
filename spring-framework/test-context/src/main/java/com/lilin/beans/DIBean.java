package com.lilin.beans;

import org.springframework.stereotype.Component;

@Component
public class DIBean {

	private String beanName="DIBean";

	@Override
	public String toString() {
		return "DIBean{" +
				"beanName='" + beanName + '\'' +
				'}';
	}
}
