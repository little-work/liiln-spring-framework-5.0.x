package com.lilin;

import com.lilin.beans.LefCycleVerification;
import com.lilin.configurations.BeanConfiguration;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainTest {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ac=
				new AnnotationConfigApplicationContext(BeanConfiguration.class);
		LefCycleVerification aa=(LefCycleVerification)ac.getBean("lefCycleVerification");
		System.out.println("最后可以用的bean"+aa+aa.d);

	}
}
