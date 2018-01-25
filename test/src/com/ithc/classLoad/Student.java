package com.ithc.classLoad;

public class Student extends Person {
	
	private String name;
	int age;
	
	
	public static void f2(){
		System.out.println("我是静态空参的方法");
	}
	
	public static void f3(int a,int b,String name){
		System.out.println(name +"赚了"+a + b+"闷");
	}

	public void f4(){
		System.out.println("我是非静态空参方法");
	}
	
	public void f5(Integer a,Integer b,String name){
		System.out.println(name +"赚了"+a + b+"闷");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
