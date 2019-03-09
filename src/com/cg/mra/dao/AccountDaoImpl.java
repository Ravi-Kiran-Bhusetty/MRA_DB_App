package com.cg.mra.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.cg.mra.beans.Account;
import com.cg.mra.utility.DatabaseConnection;

public class AccountDaoImpl implements AccountDao {

	DatabaseConnection db = new DatabaseConnection();
	Connection connection = db.database();
	Account a = new Account();

	public Account getAccountDetails(String mobileNo){
		a = null;
		try
		{
			Statement stmt = connection.createStatement();

			ResultSet rs = stmt.executeQuery("select * from recharge");
			
			while(rs.next()) {

//		connection.close();
			if (rs.getString(1).equals(mobileNo)) {
				a.setAccountBalance(rs.getDouble(4));
			} 
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return a;
	} 

	public int rechargeAccount(String mobileNo, double rechargeAmount) {
		double bal = 0;
		try
		{
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery("select * from recharge");			
			while(rs.next()) {
			if (rs.getString(1).equals(mobileNo)) {
				bal = rs.getDouble(4);
				bal += rechargeAmount;
				a.setAccountBalance(bal);
				
			} 
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return (int) bal;
	}

}
