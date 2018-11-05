package com.capgemini.mps.pi;

import java.util.InputMismatchException; 
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;


import com.capgemini.mps.exception.MobilePurchaseException;
import com.capgemini.mps.sevice.IMobileService;
import com.capgemini.mps.sevice.MobileServiceImpl;
import com.capgemini.mps.dto.*;

public class MPSTester {
	private static Scanner scanner=new Scanner(System.in);
	private static IMobileService ms=new MobileServiceImpl();
	
	public static void main(String[] args) {		
		while (true) {
			// show menu
			System.out.println();
			System.out.println();
			System.out.println("   Mobile Purchase System ");
			System.out.println("_______________________________\n");

			System.out.println("1.Add Mobile ");
			System.out.println("2.Update Price");
			System.out.println("3.Retrive All Mobiles");
			System.out.println("4.Delete Mobile");
			System.out.println("5.Get Mobile Details");
			System.out.println("6.Get Mobile Price");
			System.out.println("7.Exit");
			System.out.println("________________________________");
			System.out.println("Select an option:");
			// accept option
			try {
				int option = scanner.nextInt();
				switch (option) {
				case 1:
					  Mobile mobile = new Mobile();
					  getMobileDetails(mobile);
					  int n;
					try {
						n = addNewMobile(mobile);
						System.out.println(n);
					} catch (MobilePurchaseException e) {
						// TODO Auto-generated catch block
						System.out.println(e.getMessage());
					}
					  
					  break;
				/*case 2: 
					  System.out.println("Enter lower-limit and upper-limit price range");
					  double lowPrice=scanner.nextDouble();
					  double highPrice=scanner.nextDouble();
					  List<Mobile> mobileList1=getMobilesPriceRange(lowPrice,highPrice);
					  showMobiles(mobileList1);
					  break;*/
				case 2:
					System.out.println("Enter mobileId: ");
					  int mobileid=scanner.nextInt();
					  System.out.println("Enter new price: ");
					  double newPrice=scanner.nextDouble();
					  try {
						Integer update= updateNewPrice(mobileid,newPrice);
						System.out.println(update);
					} catch (MobilePurchaseException e) {
						// TODO Auto-generated catch block
						System.out.println(e.getMessage());
					}
					  
				case 3:
					  List<Mobile> mobileList2= getAllMobileDetails();
					  showMobiles(mobileList2);
					  break;
				case 4:
					  System.out.println("Enter mobileId: ");
					  int mobileId=scanner.nextInt();
					  Integer status=deleteMobile(mobileId);
					  System.out.println(status);
					  break;
				case 5:
					System.out.println("Enter mobileId: ");
					int mobile_id = scanner.nextInt();
					Mobile mobile1;
					try {
						mobile1 = ms.getMobileDetails(mobile_id);
						System.out.println(mobile1);
					} catch (MobilePurchaseException e) {
						// TODO Auto-generated catch block
						System.out.println(e.getMessage());
					}
					break;
					
				/*case 5: 
					  System.out.println("Enter customer name(begin with uppercase and name cannot exceed 20 characters): ");
					  String name=scanner.nextLine();					 
					  System.out.println("Enter EmailId: ");
					  String emailId= scanner.nextLine();
					  scanner.nextLine();//clear KBD buffer
					  System.out.println("Enter 10-digit phone number");
					  Long phoneNumber=scanner.nextLong();
					  CustomerValidator validator=new CustomerValidator();
					  if(validator.isValidCustomerName(name)) {
						  if(validator.isValidEmail(emailId)) {
							  if(validator.isValidPhoneNumber(phoneNumber)) {
								  PurchaseDetails purchaseDetails=
										  	new PurchaseDetails();
								  purchaseDetails.setCustomerName(name);
								  purchaseDetails.setEmailId(emailId);
								  purchaseDetails.setPhoneNumber(phoneNumber);
								  System.out.println("Enter mobile Id: ");
								  Integer mid=scanner.nextInt();
								  try {
									if(mobileService.isValidMobileId(mid)) {
										  purchaseDetails.setMobileId(mid);
										  //TODO
									}else {
										System.out.println("Enter valid mobileId");  
									}
								} catch (MobilePurchaseException e) {									
									  System.out.println(e.getMessage());
								}
							  }else {
								  System.out.println("Enter valid phone number");
							  }
						  }else {
							  System.out.println("Enter valid emailId");
						  }
					  }else {
						  System.out.println("Enter valid customer name");
					  }
					  break;*/
				case 6:
					System.out.println("Entet Mobile ID: ");
					int mobile_Id = scanner.nextInt();
					double price;
					try {
						price = getMobilePrice(mobile_Id);
						System.out.println("Price="+price);
					} catch (MobilePurchaseException e) {
						// TODO Auto-generated catch block
						System.out.println(e.getMessage());
					}
					
					break;

				case 7:
					System.out.print("Exit Mobile Purchase System");
					System.exit(0);					
				default:
					System.out.println("Enter a valid option[1-6]");
				}// end of switch
			}catch (InputMismatchException e) {
				scanner.nextLine();
				System.err.println("Please enter a numeric value, try again");
			}

		}// end of while
	}

	private static double getMobilePrice(int mobile_Id) throws MobilePurchaseException {
		// TODO Auto-generated method stub
		return ms.getMobilePrice(mobile_Id);
	}

	private static Integer updateNewPrice(int mobileid, double newPrice) throws MobilePurchaseException {
		// TODO Auto-generated method stub
		return ms.updatePrice(mobileid, newPrice);
	}

	private static int addNewMobile(Mobile mobile) throws MobilePurchaseException {
		// TODO Auto-generated method stub
		return ms.addNewMobile(mobile);
	}

	private static void getMobileDetails(Mobile mobile) {
		// TODO Auto-generated method stub
		scanner.nextLine();
		System.out.println("Enter Mobile brand Name: ");
		mobile.setName(scanner.nextLine());
		System.out.println("Enter Mobile price: ");
		mobile.setPrice(scanner.nextDouble());
		System.out.println("Enter Mobile quantity: ");
		mobile.setQuantity(scanner.nextInt());
		
	}

	private static Integer deleteMobile(int mobileId) {
		try {
			int status=ms.deleteMobile(mobileId);
			return status;
		} catch (MobilePurchaseException e) {
			 //Log to file
			 System.out.println(e.getMessage());
		}
		return null;
	}

	/*private static List<Mobile> getMobilesPriceRange(double lowPrice, double highPrice) {
		try {
			return mobileService.getMobilesPriceRange(lowPrice, highPrice);
		} catch (MobilePurchaseException e) {	
			//Log to file
			System.out.println(e.getMessage());
		}
		return null;
	}
*/
	private static void showMobiles(List<Mobile> mobileList) {
		Iterator<Mobile> iterator=mobileList.iterator();
		while(iterator.hasNext()) {
			System.out.println(iterator.next());
		}
		
	}

	private static List<Mobile> getAllMobileDetails() {
		List<Mobile> mobileList;
		try {
			mobileList = ms.getAllMobileDetails();
			return mobileList; 
		} catch (MobilePurchaseException e) {	
			//log to file
			System.out.println(e.getMessage());
		}
		return null;
	}

}


