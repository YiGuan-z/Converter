package com.student;

/**
 * power by caseycheng
 *
 * @author caseycheng
 * <p>创建时间:2022/7/12 19:42</p>
 **/
public class Course {
	String subject;
	int score;

	public Course(String subject, int score) {
		this.subject = subject;
		this.score = score;
	}

	public String getSubject() {
		return subject;
	}

	public Course setSubject(String subject) {
		this.subject = subject;
		return this;
	}

	public int getScore() {
		return score;
	}

	public Course setScore(int score) {
		this.score = score;
		return this;
	}

	@Override
	public String toString() {
		final StringBuffer sb = new StringBuffer();
		sb.append("subject='").append(subject).append('\'');
		sb.append(", score=").append(score);
		return sb.toString();
	}
}
