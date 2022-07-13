package com.cdkdl.ext;

import java.util.Scanner;

/**
 * power by caseycheng
 *
 * @author caseycheng
 * <p>创建时间:2022/7/13 16:30</p>
 **/
public class CarMain {
	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.println("按1轿车，按2客车");
		switch (scanner.nextInt()) {
			case 1: {
				int result;
				System.out.println("请输入车型");
				String name = scanner.next();
				System.out.println("需要租多少天？");
				int days = scanner.nextInt();
				Car car = new Car(name);
				Integer rent = car.getRent();
				result=rent*days;
				System.out.printf("租%d天的%s需要%dRMB", days, car.getName(), result);
				break;
			}
			case 2: {
				int result;
				System.out.println("请输入多少座");
				int seat = scanner.nextInt();
				System.out.println("需要租多少天？");
				int days = scanner.nextInt();
				PassengerCar passengerCar = new PassengerCar(seat);
				result = passengerCar.getRent() * days;
				System.out.printf("租%d天的%d座需要%dRMB", days, seat, result);

			}
		}

	}
}
