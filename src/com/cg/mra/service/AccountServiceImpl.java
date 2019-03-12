package com.cg.mra.service;

import java.sql.SQLException;

import com.cg.mra.beans.Account;
import com.cg.mra.dao.AccountDao;
import com.cg.mra.dao.AccountDaoImpl;

public class AccountServiceImpl implements AccountService {

	AccountDao ad = new AccountDaoImpl();

	public Account getAccountDetails(String mobileNo) {
		return ad.getAccountDetails(mobileNo);
	}

	public int rechargeAccount(String mobileNo, double rechargeAmount) {
		if (rechargeAmount > 0)
			return ad.rechargeAccount(mobileNo, rechargeAmount);
		else
			return -1;
	}
}
