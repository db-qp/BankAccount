// Assignment #: 5 (CreditcardAccount.java)
//         Name: Dawson Black
//    StudentID: 1212509686
//      Lecture: 1:30pm
//  Description: This class is for the creditcard aspect of
//				the bank account. Methods in this class return and set
//				the credit limit. In addition, methods in this class make
//				sure the user doesn't go over his or her credit limit and
//				applies interest to their balance.

import java.text.DecimalFormat;

public class CreditcardAccount extends BankAccount
{
	// declare instance variables
	private int creditLimitPennies;

	// constructor
	public CreditcardAccount( int balance, double interest, String acctNum, int creditLimit )
	{
		super( balance, interest, acctNum );
		creditLimitPennies = creditLimit;
	}

	// returns credit limit
	public int getCreditLimitInPennies()
	{
		return ( creditLimitPennies );
	}

	// sets credit limit
	public void setCreditLimitInPennies( int limit )
	{
		creditLimitPennies = limit;
	}

	// checks to see if there is enough money to withdraw from the account
	public boolean debit( int amountPennies )
	{
		if ( amountPennies <= creditLimitPennies && Math.abs(balanceInPennies - amountPennies) <= creditLimitPennies )
		{
			balanceInPennies -= amountPennies;
			return true;
		}
		else
		{
			return false;
		}
	}

	// applies the interest rate to the account balance
	public void applyInterest()
	{
		if ( balanceInPennies < 0 )
		{
			balanceInPennies += balanceInPennies*interestRate;
		}
	}

	// returns the account type, account id, balance, interest rate, and credit limit
	public String toString()
	{
		DecimalFormat fmt = new DecimalFormat("0.00");

		return ("\nAccount type\t:\tCreditcard" + super.toString() +
				"Credit limit\t:\t" + fmt.format(creditLimitPennies/100.00) +
				"\n\n");
	}

}