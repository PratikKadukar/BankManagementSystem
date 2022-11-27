package com.pk.bankmanagement.serviceImpl;
import java.util.Scanner;
import java.util.regex.Pattern;
import com.pk.bankmanagement.model.Account;
import com.pk.bankmanagement.service.RBI;

public class SBI implements RBI {

	Scanner sc = new Scanner(System.in);

	Account a = new Account();
	
	//code for creating account method
	
	public void createAccount() {

		System.out.println("createAccount First");
		System.out.println("Enter Account No");
		int c_accNo = sc.nextInt();

		accname();
		System.out.println("Enter Mobile No");
		Mobile();

		System.out.println("Enter Adhar No");
		adharno();
		System.out.println("Enter Gender");
		String c_gender = sc.next();
		System.out.println("Enter Age");
		int c_age = sc.nextInt();
		System.out.println("Enter Balance");
		balance();

		System.out.println("Account Created successfully");
		System.out.println("******************************************");

		a.setAccNo(c_accNo);

		a.setGender(c_gender);
		a.setAge(c_age);

	}

	public void balance() {
		double c_balance = sc.nextDouble();

		if (c_balance >= 1000) {
			a.setBalance(c_balance);
		} else {
			System.out.println("Please Enter Balance over 1000$");
			balance();
		}
	}

	public void adharno() {
		String c_adharNo = sc.next();
		boolean match = Pattern.matches("[0-9]{12}", c_adharNo);
		if (match) {
			a.setAdharNo(c_adharNo);
		} else {
			System.out.println("Please Enter 12 Digit Adhar Number");
			adharno();
		}

	}

	public void accname() {
		System.out.println("Enter Name");
		String c_name = sc.next();
		boolean match = Pattern.matches("[A-Z]{1}[a-z]{2,10}", c_name);
		if (match) {
			a.setName(c_name);
		} else {
			System.out.println("First letter of name must be capital");
			accname();
		}
	}

	public void Mobile() {
		// System.out.println("Enter Mobile No");
		String c_mobNo = sc.next();
		boolean match = Pattern.matches("[6-7-8-9]{1}[0-9]{9}", c_mobNo);
		if (match) {
			a.setMobNo(c_mobNo);
		} else {
			System.out.println("Enter 10 digit Mobile Number:");
			Mobile();
		}
	}
	
	//code for display details method
	
	public void displayAllDetails() {
		if (a.getAccNo() == 0) {
			createAccount();
		} else {
			System.out.println("**********Account details***********");
			System.out.println("Account No=" + a.getAccNo());
			System.out.println("Name=" + a.getName());
			System.out.println("Mobile No=" + a.getMobNo());
			System.out.println("Adhar No=" + a.getAdharNo());
			System.out.println("Gender=" + a.getGender());
			System.out.println("Age=" + a.getAge());
			System.out.println("Balance=" + a.getBalance());
			System.out.println("****************************************");
		}
	}
	
	//code for money deposit method
	
	@Override
	public void depositeMoney() {
		if (a.getAccNo() == 0) {
			createAccount();
		} else {

			double currentBalance = a.getBalance();

			System.out.println("Enter Deposit Money");

			double deptamt = sc.nextDouble();

			System.out.println("**************************************");

			if (deptamt >= 500) {
				double newbalance = currentBalance + deptamt;

				System.out.println("Balance after the deposit=" + newbalance);

				a.setBalance(newbalance);

			} else {
				System.out.println("Minimum deposite balance is 500");
				depositeMoney();
			}
			System.out.println("**************************************");

		}

	}
	
	//code for money withdraw method
	
	@Override
	public void withdrawal()

	{

		if (a.getAccNo() == 0) {
			createAccount();
		} else {

			double currentBalance = a.getBalance();

			System.out.println("Enter Withdraw Money ");

			System.out.println("****************************************");

			double withdrawamt = sc.nextDouble();
			if (withdrawamt >= 500) {
				if (withdrawamt < currentBalance) {
					double newbalance = currentBalance - withdrawamt;
					System.out.println("Balance after the deposit=" + newbalance);
					System.out.println("********************************************");
					a.setBalance(newbalance);
				} else {
					System.out.println("Insufficient Balance");
				}

			} else {
				System.out.println("Mininum Withdraw amount is 500");
				withdrawal();
			}
		}
	}
	
	//code for check balance method
	
	@Override
	public void balanceCheck()

	{
		if (a.getAccNo() == 0) {
			createAccount();
		} else {

			double currentBalance = a.getBalance();

			System.out.println("Current Balance is" + currentBalance);
			System.out.println("*********************************");
		}
	}
}
