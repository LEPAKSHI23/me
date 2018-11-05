package com.capgemini.mps.dao;

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.capgemini.mps.dto.Mobile;
import com.capgemini.mps.exception.MobilePurchaseException;
import com.capgemini.mps.utility.MySQLConnection;



public class MobileDaoImpl implements IMobileDao {


	public Integer addNewMobile(Mobile mobile) throws MobilePurchaseException {
		Connection connection=null;
		PreparedStatement preparedStatement=null;
		try {
			connection=MySQLConnection.getConnection();
			preparedStatement=connection.prepareStatement(QueryMapper.INSERT_MOBILE);
			//preparedStatement.setLong(1, mobile.getMobileId());
			preparedStatement.setString(1, mobile.getName());
			preparedStatement.setDouble(2,mobile.getPrice());
			preparedStatement.setInt(3, mobile.getQuantity());
			int n = preparedStatement.executeUpdate();
			return n;
		}catch(SQLException e) {
			//TODO : Log to file
			throw new MobilePurchaseException("Unable to add new mobile"+e.getMessage());
			
		}catch(Exception e) {
			//TODO : Log to file
			
			throw new MobilePurchaseException(e.getMessage());
			
		}finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public Integer deleteMobile(int mobileId) throws MobilePurchaseException {
		// TODO Auto-generated method stub
		try(Connection connection = MySQLConnection.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(QueryMapper.DELETE_MOBILE)){
			 preparedStatement.setInt(1,mobileId);
			 int n = preparedStatement.executeUpdate();
			return n;
		}catch(SQLException e){
			throw new MobilePurchaseException("Unable to delete");
		}catch(IOException e) {
			throw new MobilePurchaseException(e.getMessage());
		}
	}

	public List<Mobile> getAllMobileDetails() throws MobilePurchaseException{
		// TODO Auto-generated method stub
		try (Connection connection = MySQLConnection.getConnection();
				Statement statment = connection.createStatement();)
		{
			ResultSet resultSet=statment.executeQuery(QueryMapper.SELECT_ALL_MOBILE);
			List<Mobile> mobileList= new ArrayList<Mobile>();
			while(resultSet.next()) {
				Mobile mobile = new Mobile();
				populateMobile(resultSet, mobile);
				mobileList.add(mobile);
			}
			return mobileList;
		}catch(SQLException e) {
			e.printStackTrace();
			//Log to file
			throw new MobilePurchaseException(e.getMessage());
		}catch(IOException e) {
			e.printStackTrace();
			//Log to file
			throw new MobilePurchaseException(e.getMessage());
		}
		
	}

	private void populateMobile(ResultSet resultSet, Mobile mobile) throws SQLException {
		mobile.setMobileId(resultSet.getInt("mobile_id"));
		mobile.setName(resultSet.getString("name"));
		mobile.setPrice(resultSet.getDouble("price"));
		mobile.setQuantity(resultSet.getInt("quantity"));
	}

	@Override
	public Integer updateMobilePrice(int mobileId, Double newPrice) throws MobilePurchaseException {
		try(Connection connection = MySQLConnection.getConnection();
			 PreparedStatement preparedStatement = connection.prepareStatement(QueryMapper.UPDATE_PRICE)){
			 preparedStatement.setDouble(1,newPrice); 
			preparedStatement.setInt(2,mobileId);
			 int n = preparedStatement.executeUpdate();
			return n;
		}catch(SQLException e){
			throw new MobilePurchaseException("Unable to update");
		}catch(IOException e) {
			throw new MobilePurchaseException(e.getMessage());
		}
	}

	@Override
	public Mobile getMobileDetails(int mobileId) throws MobilePurchaseException {
		try(Connection connection=MySQLConnection.getConnection();
			CallableStatement callable=
					connection.prepareCall(QueryMapper.GET_MOBILE_DETAILS)) {
			callable.setInt(1,mobileId);
			callable.registerOutParameter(2, java.sql.Types.VARCHAR);
			callable.registerOutParameter(3, java.sql.Types.DOUBLE);
			callable.registerOutParameter(4, java.sql.Types.INTEGER);
			callable.executeQuery();
			Mobile mobile = new Mobile();
			mobile.setMobileId(mobileId);
			populateMobile(mobile,callable);
			return mobile;
		}catch(SQLException e){
			throw new MobilePurchaseException("Unable to recieve mobile details."+e.getMessage());
		}catch(IOException e) {
			throw new MobilePurchaseException(e.getMessage());
		}
	}

	private void populateMobile(Mobile mobile, CallableStatement callable) throws SQLException {
		// TODO Auto-generated method stub
		mobile.setName(callable.getString(2));
		mobile.setPrice(callable.getDouble(3));
		mobile.setQuantity(callable.getInt(4));
	}

	@Override
	public Double getMobilePrice(int mobileId) throws MobilePurchaseException {
		// TODO Auto-generated method stub
		try(Connection connection=MySQLConnection.getConnection();
				CallableStatement callable=
						connection.prepareCall(QueryMapper.GET_MOBILE_PRICE)) {
			 callable.setInt(2,mobileId);
			 callable.registerOutParameter(1,java.sql.Types.DOUBLE);
			 callable.execute();
			 double price = callable.getDouble(1);
		 return price;
		}catch(SQLException e){
			throw new MobilePurchaseException("Unable to recieve mobile price."+e.getMessage());
		}catch(IOException e) {
			throw new MobilePurchaseException(e.getMessage());
		}
	}

}
