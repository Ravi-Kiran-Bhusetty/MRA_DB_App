package com.cg.mra.ui;

import java.sql.SQLException;
import java.util.Scanner;

import com.cg.mra.beans.Account;
import com.cg.mra.exceptions.ImproperInputException;
import com.cg.mra.exceptions.InvalidCustomerException;
import com.cg.mra.service.AccountService;
import com.cg.mra.service.AccountServiceImpl;

public class MainUI {

	public static void main(String[] args) {

		AccountService as = new AccountServiceImpl();
		Account a = new Account();
		int bal;
		Scanner sc = new Scanner(System.in);
		do {
			System.out.println(
					"Menu:" + "\n" + "1. Account Balance Enquiry" + "\n" + "2. Recharge Account" + "\n" + "3. Exit");
			int menu = sc.nextInt();
			switch (menu) {
			case 1:
				System.out.println("Enter Mobile No.");
				String mobileNo = sc.next();
				if (mobileNo.length() == 10) {
					a = as.getAccountDetails(mobileNo);
					if (a != null) {
						System.out.println("Your Current Balance is " + a.getAccountBalance());
					} else {
						try {
							throw new InvalidCustomerException();
						} catch (InvalidCustomerException e) {
						}
					}
				} else {
					try {
						throw new ImproperInputException();
					} catch (ImproperInputException e) {
					}
				}
				break;

			case 2:
				System.out.println("Enter Mobile No.");
				String mobile = sc.next();
				if (mobile.length() == 10) {
					a = as.getAccountDetails(mobile);
					if (a != null) {
						System.out.println("Enter recharge amount");
						double amt = sc.nextDouble();
						bal = as.rechargeAccount(mobile, amt);
						if (bal != -1) {
							System.out.println("Your Account Recharge Successful");
							System.out.println("Hello " + a.getCustomerName() + ", Available Balance is " + bal);
						} else
							System.err.println("Invalid recharge amount");
					} else {
						System.err.println("Cannot Recharge");
						try {
							throw new InvalidCustomerException();
						} catch (InvalidCustomerException e) {
						}
					}
				} else {
					try {
						throw new ImproperInputException();
					} catch (ImproperInputException e) {
					}
				}
				break;

			case 3:
				System.exit(0);
				break;

			default:
				System.out.println("Improper Choice");
				break;
			}
		} while (true);
	}

}
