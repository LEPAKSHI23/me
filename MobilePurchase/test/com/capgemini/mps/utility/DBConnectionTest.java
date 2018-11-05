package com.capgemini.mps.utility;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.sql.SQLException;

import org.junit.jupiter.api.Test;

import com.capgemini.mps.exception.MobilePurchaseException;

class DBConnectionTest {

	@Test
	void testGetConnection() throws MobilePurchaseException, SQLException {
		try {
			assertNotNull(MySQLConnection.getConnection());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
