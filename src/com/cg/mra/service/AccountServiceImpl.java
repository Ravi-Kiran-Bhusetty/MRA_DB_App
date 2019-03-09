package com.cg.mra.service;

import com.cg.mra.beans.Account;
import com.cg.mra.dao.AccountDao;
import com.cg.mra.dao.AccountDaoImpl;

public class AccountServiceImpl implements AccountService {

	AccountDao ad = new AccountDaoImpl();
	//Account a = new Account("", "", 0.0);

	public Account getAccountDetails(String mobileNo) {
		//a = ad.getAccountDetails(mobileNo);
		return ad.getAccountDetails(mobileNo);
	}

	public int rechargeAccount(String mobileNo, double rechargeAmount) {
		//int r = ad.rechargeAccount(mobileNo, rechargeAmount);
		return ad.rechargeAccount(mobileNo, rechargeAmount);
	}
}
