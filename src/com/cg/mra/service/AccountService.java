package com.cg.mra.service;

import java.sql.SQLException;

import com.cg.mra.beans.Account;

public interface AccountService {

	Account getAccountDetails(String mobileNo);
	int rechargeAccount(String mobileNo, double rechargeAmount);
}