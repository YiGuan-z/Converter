package com.student;

public class Student {
	private String name;
	private int age;
	private Course course;

	public Student(String name, int age, Course course) {
		this.name = name;
		this.age = age;
		this.course = course;
	}

	public String getName() {
		return name;
	}

	public Student setName(String name) {
		this.name = name;
		return this;
	}

	public int getAge() {
		return age;
	}

	public Student setAge(int age) {
		this.age = age;
		return this;
	}

	public Course getCourse() {
		return course;
	}

	public Student setCourse(Course course) {
		this.course = course;
		return this;
	}

	@Override
	public String toString() {
		final StringBuffer sb = new StringBuffer("Student{");
		sb.append("name='").append(name).append('\'');
		sb.append(", age=").append(age);
		sb.append(", course{").append(course);
		sb.append('}');
		sb.append('}');
		return sb.toString();
	}
}