package com.cdkdl.ext;

/**
 * power by caseycheng
 *
 * @author caseycheng
 * <p>创建时间:2022/7/13 16:22</p>
 **/
abstract public class AbstractCar {
	private String name;

	public String getName() {
		return name;
	}

	public AbstractCar setName(String name) {
		this.name = name;
		return this;
	}

	abstract public Integer getRent();
}
