/*
 
November 27, 2014
HJ_InClass2

For this in-class assignment, you are to complete the program by writing the methods getint,
   getDigit and noVowels so that the program can produce the output shown.

   I would suggest that you write near-empty methods with return statements first to get the
   program running, then work on the problems themselves.

   YOU ARE NOT ALLOWED TO CHANGE THE MAIN PROGRAM.
*/
import java.awt.*;
import hsa.Console;

public class HJ_InClass2
{
    static Console c;

    /* REQUIREMENTS
       getInt is an overloaded method that uses a loop to do a range check and displays an error
       message as shown below if the user enters a value outside the range.  Since you did this
       as an assignment and have access to your files, this should be automatic marks.

       getDigit will return the specified digit from the given number.  If the digit doesn't exist
       (ex. 3rd digit of 57) or a negative value is entered, a -1 should be returned.

       noVowels will return a version of the accepted string that doesn't have any vowels
       (caps or small AEIOU)

       BONUS METHOD
       excluded will accept an additional string that contains the characters to be excluded
       from the returned version
    */

    //***************************getInt with one parameter*********************
    public static int getInt (int a)
    {
	boolean invalid = false; //boolean as false
	int in;
	do
	{
	    in = c.readInt (); //input
	    if (in > a || in < 0) //if out of bounds
	    {
		invalid = true;
		c.print ("Not in range - 0 to " + a + ": "); //invalid and error message
	    }
	    else
	    {
		invalid = false;
	    }
	}
	while (invalid);
	return in; //return value
    }


    //***************************getInt with two parameters*********************
    public static int getInt (int a, int b)
    {
	boolean invalid = false; //boolean
	int in;
	do
	{

	    in = c.readInt (); //input
	    if (in > b || in < a) //if out of bounds
	    {
		invalid = true;
		c.print ("Not in range - " + a + " to " + b + ": "); //invalid and error message
	    }
	    else
	    {
		invalid = false;
	    }
	}
	while (invalid);
	return in; //return value
    }


    //***************************getDigit with two parameters*********************
    public static int getDigit (int num, int digit)
    {
	String number = num + ""; //convert the number into a String
	char[] digits = number.toCharArray (); //convert the digits into a char array
	try
	{
	    return digits [digit - 1] - 48; //convert from ascii and return the actual value of the digit
	}
	catch (ArrayIndexOutOfBoundsException e)
	{
	    return -1; //if the index of the array is out of bounds return -1
	}
    }


    //***************************noVowels with one parameter*********************
    public static String noVowels (String message)
    {
	char[] letters = message.toCharArray (); //create string into character array
	char[] vowels = {'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'}; //array of invalid vowels
	int counter = letters.length; //counter of array
	for (int i = 0 ; i < letters.length ; i++)
	{
	    for (int j = 0 ; j < vowels.length ; j++)
	    {
		if (letters [i] == vowels [j]) //if that char array element is a vowel
		{
		    for (int k = i + 1 ; k < counter ; k++)
		    {
			letters [k - 1] = letters [k]; //removing the vowel from the array
		    }
		    counter--; //decrementing the counter
		    i--;
		    break;
		}
	    }
	}
	char[] letters2 = new char [counter]; //the final array without vowels
	for (int i = 0 ; i < counter ; i++)
	{
	    letters2 [i] = letters [i]; //the final array without vowels
	}
	String noVowels = new String (letters2); //Converting array back into string
	return noVowels; //return value
    }


    //***************************exlude with two parameters*********************
    public static String exclude (String message, String exclude)
    {
	char[] letters = message.toCharArray (); //create string into character array
	char[] excluded = exclude.toCharArray (); //array of excluded values
	int counter = letters.length; //counter of array
	for (int i = 0 ; i < letters.length ; i++)
	{
	    for (int j = 0 ; j < excluded.length ; j++)
	    {
		if (letters [i] == excluded [j]) //if that char array element is an excluded value
		{
		    for (int k = i + 1 ; k < counter ; k++)
		    {
			letters [k - 1] = letters [k]; //removing the excluded values from the array
		    }
		    counter--; //decrementing the counter
		    i--;
		    break;
		}
	    }
	}
	char[] letters2 = new char [counter]; //the final array without excluded values
	for (int i = 0 ; i < counter ; i++)
	{
	    letters2 [i] = letters [i]; //the final array without excluded values
	}
	String excludedMsg = new String (letters2); //Converting array back into string
	return excludedMsg; //return value
    }


    //***************************MAIN method*********************
    public static void main (String[] args)
    {
	c = new Console ();

	c.print ("Enter an integer from 0 to 999: ");
	int number = getInt (999); // forces user to enter value from 0 to 999

	c.print ("\nWhich digit do you want?(1-3): ");
	int digit = getInt (1, 3); // forces user to enter value from 1 to 3

	c.println ("\nThe digit you requested is " + getDigit (number, digit));

	c.print ("\n\nEnter a secret message: ");
	String message = c.readLine ();

	c.println ("\nThe no vowel version is  " + noVowels (message));

	c.println ("\nThe excluded letters version is " + exclude (message, "AEIOUaeiou"));
    } // main method
} // Inclass2 class

/* Sample run

   Enter an integer from 0 to 999: 9876
   Not in range - 0 to 999: 987

   Which digit do you want?(1-3): 1

   The digit you requested is 9


   Enter a secret message: This is a test

   The no vowel version is  Ths s  tst
*/
