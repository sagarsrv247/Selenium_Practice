package DatabaseTesting;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;

import org.apache.commons.lang3.StringUtils;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class StoredProceduresDBTesting {
	
	Connection con = null;
	Statement stmt = null;
	ResultSet rs;
	CallableStatement cStmt;
	ResultSet rs1;
	ResultSet rs2;
	
	@BeforeClass
	void setup() throws SQLException
	{
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/classicmodels","root","root");
	}
	
	@AfterClass
	void tearDown() throws SQLException
	{
		con.close();
	}
	@Test(priority=1)

	void test_storedProcedureExist() throws SQLException
	{
		stmt=con.createStatement();
		rs = stmt.executeQuery("SHOW PROCEDURE STATUS WHERE Name='SelectAllCustomers'");
		rs.next();
		Assert.assertEquals(rs.getString("Name"), "SelectAllCustomers");
		
	}
	@Test(priority=2)
	void test_SelectAllCustomers() throws SQLException
	{
		cStmt = con.prepareCall("{CALL SelectAllCustomers()}");
		rs1 = cStmt.executeQuery();		//resultset 1
		
		
		Statement stmt = con.createStatement();
		rs2 = stmt.executeQuery("SELECT * FROM CUSTOMERS");
		Assert.assertEquals(compareResultSets(rs1,rs2), true);
		
		}
	
	@Test(priority=3)
	void test_SelectAllCustomersByCity() throws SQLException
	{
		cStmt = con.prepareCall("{CALL SelectAllCustomersByCity(?)}");
		cStmt.setString(1, "Singapore");
		rs1 = cStmt.executeQuery();		//resultset 1
		
		
		Statement stmt = con.createStatement();
		rs2 = stmt.executeQuery("SELECT * FROM CUSTOMERS WHERE CITY = 'Singapore'");
		Assert.assertEquals(compareResultSets(rs1,rs2), true);
		
	}
	@Test(priority=4)
	void test_SelectAllCustomersByCityAndPin() throws SQLException
	{
		cStmt = con.prepareCall("{CALL SelectAllCustomersByCityAndPin(?,?)}");
		cStmt.setString(1, "Singapore");
		cStmt.setString(2, "079903");
		rs1 = cStmt.executeQuery();		//resultset 1
		
		
		Statement stmt = con.createStatement();
		rs2 = stmt.executeQuery("SELECT * FROM CUSTOMERS WHERE CITY = 'Singapore'");
		Assert.assertEquals(compareResultSets(rs1,rs2), true);
		
	}
	@Test(priority=5)
	void test_get_order_by_cust() throws SQLException
	{
		cStmt = con.prepareCall("{CALL get_order_by_cust(?,?,?,?,?)}");
		cStmt.setInt(1,141);
		cStmt.registerOutParameter(2, Types.INTEGER);
		cStmt.registerOutParameter(3, Types.INTEGER);
		cStmt.registerOutParameter(4, Types.INTEGER);
		cStmt.registerOutParameter(5, Types.INTEGER);
		cStmt.executeQuery();
		
		int shipped = cStmt.getInt(2);
		int cancelled = cStmt.getInt(3);
		int resolved = cStmt.getInt(4);
		int disputed = cStmt.getInt(5);
		
		//System.out.println(shipped+" "+cancelled+" "+resolved+" "+disputed);
		
		Statement stmt =con.createStatement();
		rs = stmt.executeQuery("select (SELECT COUNT(*) INTO shipped FROM ORDERS WHERE customerNumber = cust_no AND status = 'Shipped')as Shipped,(SELECT COUNT(*) INTO canceled FROM ORDERS WHERE customerNumber = cust_no AND status = 'Canceled') as Canceled,(SELECT COUNT(*) INTO resolved FROM ORDERS WHERE customerNumber = cust_no AND status = 'Resolved')as Resolved,(SELECT COUNT(*) INTO disputed FROM ORDERS WHERE customerNumber = cust_no AND status = 'Disputed')as Disputed;");
	
		rs.next();
		
		
		int exp_shipped = rs.getInt("Shipped");
		int exp_cancelled = rs.getInt("Canceled");
		int exp_resolved = cStmt.getInt("Resolved");
		int exp_disputed = cStmt.getInt("Disputed");
		
		
		if(shipped==exp_shipped && cancelled==exp_cancelled && resolved==exp_resolved&&disputed==exp_disputed )
		{
			Assert.assertTrue(true);
		}
		else
		{
			Assert.assertTrue(false);
		}
		
	}
	
	@Test(priority=6)
	void test_getCustomerShipping() throws SQLException
	{
		cStmt = con.prepareCall("{CALL GetCustomerShipping(?,?)}");
		cStmt.setInt(1,121);
		cStmt.registerOutParameter(2, Types.VARCHAR);

		cStmt.executeQuery();
		
		String shippingTime = cStmt.getString(2);


		
		Statement stmt =con.createStatement();
		rs = stmt.executeQuery("SELECT country, CASE customerCountry WHEN 'USA' THEN '2-day Shipping' WHEN 'Canada' THEN SET '3-day Shipping' ELSE '5-day Shipping' END AS ShippingTime FROM customers WHERE customerNumber =112;");
		
		
		String exp_shippingTime = rs.getString("ShippingTime");

		
		
		if(shippingTime==exp_shippingTime)
		{
			Assert.assertTrue(true);
		}
		else
		{
			Assert.assertTrue(false);
		}
		
	}
	
	
	
	
	
	public boolean compareResultSets(ResultSet resultset1, ResultSet resultset2 ) throws SQLException
	{
		while(resultset1.next())
		{
			resultset2.next();
			int count = resultset1.getMetaData().getColumnCount();
			for(int i=1;i<=count;i++)
			{
				if(!StringUtils.equals(resultset1.getString(i), resultset1.getString(i) ))
				{
					return false;
				}
			}
		}
		return true;
		
	}

}
