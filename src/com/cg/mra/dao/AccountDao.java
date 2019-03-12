package com.cg.mra.dao;

import java.sql.SQLException;

import com.cg.mra.beans.Account;

public interface AccountDao {

	Account getAccountDetails(String mobileNo);
	int rechargeAccount(String mobileNo, double rechargeAmount);
}
