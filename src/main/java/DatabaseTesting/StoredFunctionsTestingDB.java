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

public class StoredFunctionsTestingDB {
	
	Connection con = null;
	Statement stmt;
	ResultSet rs;
	ResultSet rs1;
	ResultSet rs2;
	CallableStatement cStmt;
	
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
	void test_storedFunctionExists() throws SQLException
	{
		rs=con.createStatement().executeQuery("SHOW FUNCTION STATUS WHERE Name = 'CustomerLevel'");
		rs.next();
		Assert.assertEquals(rs.getString("Name"), "CustomerLevel");
		
	}
	@Test(priority=2)
	void test_CustomerLevel_with_Sql() throws SQLException
	{
		rs1=con.createStatement().executeQuery("SELECT customerName, CustomerLevel(creditLimit) FROM customers;");
		rs2=con.createStatement().executeQuery("SELECT customerName, CASE WHEN creditLimit>50000 THEN 'PLATINUM' WHEN creditLimit>10000 AND creditLimit<50000 THEN 'GOLD' WHEN creditLimit<10000 THEN 'SILVER' END AS customerLevel FROM customers;");
		
		Assert.assertEquals(compareResultSets(rs1, rs2), true);
		
		
	}
	@Test(priority=3)
	void test_CustomerLevel_with_StoredProcedure() throws SQLException
	{
		cStmt = con.prepareCall("{Call GetCustomerLevel(?,?)}");
		cStmt.setInt(1, 131);
		cStmt.registerOutParameter(2, Types.VARCHAR);
		cStmt.executeQuery();
		String custLevel = cStmt.getString(2);
		rs = con.createStatement().executeQuery("SELECT customerName, CASE WHEN creditLimit>50000 THEN 'Platinum' WHEN creditLimit>=10000 AND creditLimit<50000 THEN 'Gold' WHEN creditLimit<10000 THEN 'Silver' END AS customerLevel FROM customers WHERE customerNumber = 131;");
		rs.next();
		String exp_custLevel = rs.getString("customerLevel");
		Assert.assertEquals(custLevel, exp_custLevel);
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
