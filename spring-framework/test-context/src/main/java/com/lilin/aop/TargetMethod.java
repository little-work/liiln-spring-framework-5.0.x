package com.lilin.aop;

public class  TargetMethod {


	public String execute() {
		System.out.println("目标方法执行了");
		int d=6+0;
		return "方法返回了";
	}
}
