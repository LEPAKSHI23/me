package com.capgemini.mps.sevice;

import java.util.List;

import com.capgemini.mps.dao.IMobileDao;
import com.capgemini.mps.dao.MobileDaoImpl;
import com.capgemini.mps.dto.Mobile;
import com.capgemini.mps.exception.MobilePurchaseException;

public class MobileServiceImpl implements IMobileService {
	private IMobileDao mobiledao = new MobileDaoImpl();

	@Override
	public Integer addNewMobile(Mobile mobile) throws MobilePurchaseException {
		//TODO validate mobile details
		return mobiledao.addNewMobile(mobile);
	}

	@Override
	public Integer deleteMobile(int mobileId) throws MobilePurchaseException {
		// TODO Auto-generated method stub
		return mobiledao.deleteMobile(mobileId);
	}

	@Override
	public Mobile getMobileDetails(int mobileId) throws MobilePurchaseException {
		// TODO Auto-generated method stub
		return mobiledao.getMobileDetails(mobileId);
	}

	@Override
	public List<Mobile> getAllMobileDetails() throws MobilePurchaseException {
		// TODO Auto-generated method stub
		return mobiledao.getAllMobileDetails();
	}

	@Override
	public Integer updatePrice(int mobileId, double newPrice) throws MobilePurchaseException {
		// TODO Auto-generated method stub
		return mobiledao.updateMobilePrice(mobileId, newPrice);
	}

	@Override
	public double getMobilePrice(int mobile_Id) throws MobilePurchaseException {
		// TODO Auto-generated method stub
		return mobiledao.getMobilePrice(mobile_Id);
	}

}
