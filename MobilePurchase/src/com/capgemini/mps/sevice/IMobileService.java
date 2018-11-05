package com.capgemini.mps.sevice;

import java.util.List;

import com.capgemini.mps.dto.Mobile;
import com.capgemini.mps.exception.MobilePurchaseException;

public interface IMobileService {
	Integer addNewMobile(Mobile mobile) throws MobilePurchaseException;
	Integer deleteMobile(int mobileId) throws MobilePurchaseException;
	Mobile getMobileDetails(int mobileId) throws MobilePurchaseException;
	Integer updatePrice(int mobileId,double newPrice) throws MobilePurchaseException;
	List<Mobile> getAllMobileDetails() throws MobilePurchaseException;
	double getMobilePrice(int mobile_Id) throws MobilePurchaseException;

}
