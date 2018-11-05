package com.capgemini.mps.dao;

import java.util.List;

import com.capgemini.mps.dto.Mobile;
import com.capgemini.mps.exception.MobilePurchaseException;

public interface IMobileDao {
	
	Integer addNewMobile(Mobile mobile) throws MobilePurchaseException;
	Integer deleteMobile(int mobileId) throws MobilePurchaseException;
	Mobile getMobileDetails(int mobileId) throws MobilePurchaseException;
	Integer updateMobilePrice(int mobileId,Double newPrice) throws MobilePurchaseException;
	List<Mobile> getAllMobileDetails() throws MobilePurchaseException;
	Double getMobilePrice(int mobileId) throws MobilePurchaseException;
}
