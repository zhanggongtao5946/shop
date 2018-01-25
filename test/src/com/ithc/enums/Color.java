package com.ithc.enums;

public enum Color {
	
	red("红色",1),yellow("黄色",2),green("绿色",3),black("黑色",4),blue("蓝色",5);
	
	private String name;
	private int index;
	
	private Color(String name, int index) {
		this.name = name;
		this.index = index;
	}
	
	public static String getName(int index){
		for (Color c : Color.values()) {
			if(c.getIndex() == index){
				return c.name;
			}
		}
		
		return null;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}
	
	

}
