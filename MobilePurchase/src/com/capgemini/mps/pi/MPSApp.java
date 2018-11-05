package com.capgemini.mps.pi;

import java.util.Scanner;

import com.capgemini.mps.dto.Mobile;
import com.capgemini.mps.exception.MobilePurchaseException;
import com.capgemini.mps.sevice.IMobileService;
import com.capgemini.mps.sevice.MobileServiceImpl;

public class MPSApp {
	private static Scanner sc = new Scanner(System.in);
	private static IMobileService mobileservice = new MobileServiceImpl();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Mobile mobile = new Mobile();
		getMobileDetails(mobile);
		try {
			int n = addNewMobile(mobile);
			System.out.println(n);
			//Log success or failure status to logs
		}catch(MobilePurchaseException e) {
			//Log error messages
			System.out.println(e.getMessage());
		}

	}
	
	private static int addNewMobile(Mobile mobile) throws MobilePurchaseException {
		// TODO Auto-generated method stub
			return mobileservice.addNewMobile(mobile);
	}

	private static void getMobileDetails(Mobile mobile) {
		System.out.println("Enter Mobile brand Name: ");
		mobile.setName(sc.nextLine());
		System.out.println("Enter Mobile price: ");
		mobile.setPrice(sc.nextDouble());
		System.out.println("Enter Mobile quantity: ");
		mobile.setQuantity(sc.nextInt());
	}

}
