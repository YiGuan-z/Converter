package com.student;

import org.junit.jupiter.api.Test;

/**
 * power by caseycheng
 *
 * @author caseycheng
 * <p>创建时间:2022/7/12 19:47</p>
 **/
public class StudentTest {
	@Test
	void tesetStu() {
		Student student = new Student("黄小铭", 14, new Course("语文", 88));
		Student student1 = new Student("王飞", 15, new Course("数学", 98));
		System.out.println(student);
		System.out.println(student1);
	}
}
