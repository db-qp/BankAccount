// Assignment #: 5 (BankAccountParser.java)
//         Name: Dawson Black
//    StudentID: 1212509686
//      Lecture: 1:30pm
//  Description: This class allows the user to create a new
//				Checking, Savings, or Creditcard account.

public class BankAccountParser
{
	// method that splits the inputed string by '/'
	public static BankAccount parseStringToBankAccount( String line )
	{
		BankAccount accountype = null;
		int count = 0;

		// for loop that counts how much '/' there are in the string
		for ( int i = 0; i < line.length(); i++ )
		{
			if ( line.charAt(0) == '/' )
			{
				count++;
			}
		}

		// creates an array and puts the strings in each element of array
		String [] parameters = new String[count];
		parameters = line.split("/");

		// determines what type of account it is and creates a new account and returns it.
		if ( parameters[0].equalsIgnoreCase("SA") )
		{
			SavingsAccount n = new SavingsAccount( Integer.parseInt(parameters[3]), Double.parseDouble(parameters[2]), parameters[1] );

			return n;
		}
		else if ( parameters[0].equalsIgnoreCase("CH") )
		{
			CheckingAccount n = new CheckingAccount( Integer.parseInt(parameters[3]), Double.parseDouble(parameters[2]), parameters[1], Integer.parseInt(parameters[4]) );

			return n;
		}
		else
		{
			CreditcardAccount n = new CreditcardAccount( Integer.parseInt(parameters[3]), Double.parseDouble(parameters[2]), parameters[1], Integer.parseInt(parameters[4]) );

			return n;
		}
	}
}
