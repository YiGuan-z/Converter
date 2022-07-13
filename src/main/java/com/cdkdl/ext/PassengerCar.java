package com.cdkdl.ext;

/**
 * power by caseycheng
 *
 * @author caseycheng
 * <p>创建时间:2022/7/13 16:28</p>
 **/
public class PassengerCar extends AbstractCar{
	private Integer quantity;

	public PassengerCar(Integer quantity) {
		this.quantity = quantity;
	}

	public PassengerCar setQuantity(Integer quantity) {
		this.quantity = quantity;
		return this;
	}

	@Override
	public Integer getRent() {
		if (quantity<=16){
			return 800;
		}else if (quantity>16){
			return 1500;
		}
		return null;
	}
}
