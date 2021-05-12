// Assignment #: 5 (CheckingAccount.java)
//         Name: Dawson Black
//    StudentID: 1212509686
//      Lecture: 1:30pm
//  Description: This class is one of the child classes of BankAccount.
//				This class controls the Checking Account of the BankAccount.
//				Methods in this class set and return the over draft fee, apply
//				interest to the checking account, and makes sure an over draft fee
//				is charged if there is a negative balance in the checking account.

import java.text.DecimalFormat;

public class CheckingAccount extends BankAccount
{
	// declaring the instance variables
	private int overdraftFeePennies;

	// constructor
	public CheckingAccount( int balance, double interest, String acctNum, int overDraft )
	{
		super( balance, interest, acctNum );
		overdraftFeePennies = overDraft;
	}

	// returns the over draft fee
	public int getOverdraftFee()
	{
		return ( overdraftFeePennies );
	}

	// sets the over draft fee
	public void setOverdraftFee( int fee )
	{
		overdraftFeePennies = fee;
	}

	// makes sure that if there is a negative balance in the account, then the user will be charged with an over draft fee
	public boolean debit( int amountPennies )
	{
		if ( amountPennies > balanceInPennies )
		{
			balanceInPennies -= amountPennies + overdraftFeePennies;
			return false;
		}
		else
		{
			balanceInPennies -= amountPennies;
			return true;
		}
	}

	// applies interest to the checking account
	public void applyInterest()
	{
		if ( balanceInPennies > 0 )
		{
			balanceInPennies += balanceInPennies*interestRate;
		}
	}

	// returns the account type, account id, balance, interest rate, and over draft fee
	public String toString()
	{
		DecimalFormat fmt = new DecimalFormat("0.00");

		return ( "\nAccount type\t:\tChecking" +
				super.toString() + "Overdraft fee\t:\t" +
				fmt.format(overdraftFeePennies/100.00) + "\n\n" );
	}
}
