package com.ithc.classLoad;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

@SuppressWarnings("all")
public class Dome {
	public static void main(String[] args) throws Exception {
		
		Class s = Class.forName("com.ithc.classLoad.Student");
//		Student s = new Student();
		//创建新的实例: 调用静态的空参方法
		Method m = s.getDeclaredMethod("f2");
		m.invoke(s);
		//调用静态有参数方法
		Method m1 = s.getDeclaredMethod("f3", int.class,int.class,String.class);
		m1.invoke(s,5,6,"小米");
		
		//调用非静态空参数方法
		//1.创建一个新的实例
		Object obj = s.newInstance();
		Method m2 = s.getDeclaredMethod("f4");
		m2.invoke(obj);
		
		// 调用非静态有参数方法
		Object obj1 = s.newInstance();
		Method m3 = s.getDeclaredMethod("f5", Integer.class,Integer.class,String.class);
		m3.invoke(obj1,6,6,"老湿");
		
		// 给私有的属性赋值
		Object obj2 = s.newInstance();
		Field field = s.getDeclaredField("name");
		
		
	}
}
