package com.luo.controller;

import java.util.Scanner;
import com.luo.service.Service;
import com.luo.service.Stroy1Service;
import com.luo.service.Stroy2Service;

public class PublishController {

	/*
	 * private static final Integer COUNT = 10000; private static final Integer
	 * ThreadNum = 1;
	 */

	public int publish(String stroy) {

		Service service = null;
		if (stroy.equals("story1")) {
			service = new Stroy1Service();
			service.publish("PB_03_2018");
			return 1;
		} else if (stroy.equals("story2")) {
			service = new Stroy2Service();
			service.publish("PB_03_2018");
			return 2;
		} else {
			return 0;
		}

	}

	public static void main(String[] args) throws InterruptedException {
		PublishController controller = new PublishController();
		Scanner input = new Scanner(System.in);

		String s;

		while (true) {

			System.out.println("Please enter operation(story1;story2;end;) then keyboard entry:  ");
			s = input.nextLine();
			if (s.equals("story1")) {
				controller.publish(s.trim());

			} else if (s.equals("story2")) {
				controller.publish(s);

			} else if (s.equals("end")) {
				break;
			} else {
				System.out.println("Please enter operation(story1;story2;end:) ");
			}

			Thread.sleep(2000);

		}
		input.close();
		System.out.println("Program is closed!! ");

	}

}
