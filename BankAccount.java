// Assignment #: 5 (BankAccount.java)
//         Name: Dawson Black
//    StudentID: 1212509686
//      Lecture: 1:30pm
//  Description: This abstract class is the parent class of CreditcardAccount,
//				SavingsAccount, and Checking Account. It shares 3
//				instance variables and two methods with the child classes, which
//				allows me to reuse the code.

import java.text.DecimalFormat;

public abstract class BankAccount
{
	// declare instance variables
	protected int balanceInPennies;
	protected double interestRate;
	protected String accountNumber;

	// constructor
	public BankAccount( int balance, double interest, String acctNum )
	{
		balanceInPennies = balance;
		interestRate = interest;
		accountNumber = acctNum;
	}

	// returns account number
	public String getAccountNumber()
	{
		return ( accountNumber );
	}

	// sets the account number
	public void setAccountNumber( String acountNo )
	{
		accountNumber = acountNo;
	}

	// returns the balance
	public int getBalanceInPennies()
	{
		return ( balanceInPennies );
	}

	// adds credit to the balance if it is positive. returns true if positive and false if negative
	public boolean credit( int amountPennies )
	{
		if ( amountPennies > 0 )
		{
			balanceInPennies += amountPennies;
			return (true);
		}
		else
		{
			return (false);
		}

	}

	// abstract method that will be used in child classes, CreditcardAccount and CheckingAccount
	public abstract boolean debit( int amountPennies );

	// returns the interest rate
	public double getInterestRate()
	{
		return (interestRate);
	}

	// sets the interest rate
	public void setInterestRate( double rate )
	{
		interestRate = rate;
	}

	// abstract method that will be used in child classes, CreditcardAccount, CheckingAccount, and SavingsAccount
	public abstract void applyInterest();

	// returns the account id, balance, and interest rate
	public String toString()
	{
		DecimalFormat fmt = new DecimalFormat("0.00");

		return ( "\nAccount ID\t:\t" + accountNumber
				+ "\nBalance\t\t:\t" + fmt.format(balanceInPennies/100.00)
				+ "\nInterest rate\t:\t" + fmt.format(interestRate) + "\n" );
	}
}
