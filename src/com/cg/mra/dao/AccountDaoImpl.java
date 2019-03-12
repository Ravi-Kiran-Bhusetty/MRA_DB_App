package com.cg.mra.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.cg.mra.beans.Account;
import com.cg.mra.utility.DatabaseConnection;

public class AccountDaoImpl implements AccountDao {

	DatabaseConnection db = new DatabaseConnection();
	Connection connection = db.database();
	Account a = new Account();

	public Account getAccountDetails(String mobileNo) {
		int flag = 0;
		try {
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery("select * from recharge");
			while (rs.next()) {
				if (rs.getString(1).equals(mobileNo)) {

					a.setAccountBalance(rs.getDouble(4));
					a.setCustomerName(rs.getString(3));
					flag++;
				}
			}
		} catch (Exception e) {
		}
		if (flag != 0)
			return a;
		else
			return null;

	}

	public int rechargeAccount(String mobileNo, double rechargeAmount) {
		double bal = 0;
		try {
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery("select * from recharge");
			while (rs.next()) {
				if (rs.getString(1).equals(mobileNo)) {
					bal = rs.getDouble(4);
					bal += rechargeAmount;
					a.setAccountBalance(bal);
				}
			}
			PreparedStatement preparedStatement = connection
					.prepareStatement("update recharge set balance = ? where mobileNo = ?");
			preparedStatement.setString(2, mobileNo);
			preparedStatement.setDouble(1, a.getAccountBalance());
			preparedStatement.executeUpdate();
		} catch (Exception e) {
		}
		return (int) bal;
	}

}
