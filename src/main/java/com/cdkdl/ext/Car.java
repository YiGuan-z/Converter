package com.cdkdl.ext;

/**
 * power by caseycheng
 *
 * @author caseycheng
 * <p>创建时间:2022/7/13 16:26</p>
 **/
public class Car extends AbstractCar {
	public Car(String name) {
		super();
		super.setName(name);
	}
	public Integer getRent(){
		switch (super.getName()){
			case "别克商务舱GL8":
				return 600;
			case "宝马550i":
				return 500;
			case "别克林荫大道":
				return 300;
			default:
				return null;
		}
	}
}
