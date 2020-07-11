package com.mj;

public class Person {
	private int age;
	private float height;
	private String name;

	public Person(int age, float height, String name) {
		super();
		this.age = age;
		this.height = height;
		this.name = name;
	}

	@Override
	public int hashCode() {
		int hashCode = Integer.hashCode(age) * 31;
		hashCode = hashCode *31 +Float.hashCode(height);
		hashCode = hashCode * 31 + (name != null ? name.hashCode() : 0);
		return hashCode;
	}
	
	//用来比较两个对象是否相等
	@Override
	public boolean equals(Object obj) {
		//内存地址
		if(this == obj ) return true;
		if(obj == null || obj.getClass() != getClass()) return false;
//		if(obj == null || !(obj instanceof Person)) return false;
		
		//比较成员变量
		Person person = (Person)obj;
		return person.age == age 
				&& person.height == height
				&& (person.name == null ? name == null : person.name.equals(name));
	}
	
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public float getHeight() {
		return height;
	}
	public void setHeight(float height) {
		this.height = height;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
