// Assignment #: 5 (SavingsAccount.java)
//         Name: Dawson Black
//    StudentID: 1212509686
//      Lecture: 1:30pm
//  Description: This class is a child class of BankAccount, and controls
//				the savings account. The methods in this class make sure
//				the account doesn't have a negative balance, and applies
//				interest to the account.

public class SavingsAccount extends BankAccount
{
	// constructor
	public SavingsAccount( int balance, double interest, String acctNum )
	{
		super ( balance, interest, acctNum );
	}

	// makes sure that the account does not go in the negatives with a withdraw.
	// If the withdraw is vaild then it will withdraw the money from the account.
	public boolean debit( int amountPennies )
	{
		if ( amountPennies > balanceInPennies )
		{
			return false;
		}
		else
		{
			balanceInPennies -= amountPennies;
			return true;
		}
	}

	// applies interest to the account
	public void applyInterest()
	{
		if ( balanceInPennies > 0 )
		{
			balanceInPennies += balanceInPennies*interestRate;
		}
	}

	// prints the account type, account id, balance, and interest rate
	public String toString()
	{
		return( "\nAccount type\t:\tSavings" + super.toString() + "\n" );
	}
}