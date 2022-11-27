package com.pk.bankmanagement.client;

import java.util.Scanner;

import com.pk.bankmanagement.service.RBI;
import com.pk.bankmanagement.serviceImpl.SBI;

// simple bank management program using core java techniques only..

public class Test {

	public static void main(String[] args)

	{
		
		Scanner s = new Scanner(System.in);
		RBI bank = new SBI();

		// Below code for selection of specific task

		while (true) {
			System.out.println("Enter 1 for Creating Account");
			System.out.println("Enter 2 for Display Details");
			System.out.println("Enter 3 for Deposit Money");
			System.out.println("Enter 4 for Withdraw Money");
			System.out.println("Enter 5 for Balance Check");
			System.out.println("Enter 6 to exit");

			int x = s.nextInt();

			switch (x) {
			case 1:
				bank.createAccount();
				break;

			case 2:
				bank.displayAllDetails();
				break;

			case 3:
				bank.depositeMoney();
				break;
			case 4:
				bank.withdrawal();
				break;

			case 5:
				bank.balanceCheck();
				break;

			case 6:
				System.exit(0);
				break;
			default:
				System.out.println("Invalid input");

			}

		}

	}

}
