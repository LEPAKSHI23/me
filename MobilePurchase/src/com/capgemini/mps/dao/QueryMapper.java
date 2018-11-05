package com.capgemini.mps.dao;

public interface QueryMapper {
	
	public static final String INSERT_MOBILE="INSERT INTO mobiles(name,price,quantity) VALUES(?,?,?)";
	public static final String DELETE_MOBILE="DELETE FROM mobiles WHERE mobile_id=?";
	public static final String SELECT_MOBILE="SELECT * FROM mobiles WHERE mobile_id=?";
	public static final String SELECT_ALL_MOBILE="SELECT * FROM mobiles";
	public static final String UPDATE_PRICE="UPDATE mobiles SET price = ? WHERE mobile_id=?";
	public static final String GET_MOBILE_DETAILS="{call get_mobile_details(?,?,?,?)}";
	public static final String GET_MOBILE_PRICE="{?=call get_mobile_price(?)}";

}
