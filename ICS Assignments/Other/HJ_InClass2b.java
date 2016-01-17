/* For this in-class assignment, you are to complete the program by writing these methods so that
   the program can produce the output shown.

   I would suggest that you write near-empty methods with return statements first to get the
   program running, then work on the problems themselves.

   1. numCaps accepts a string, then returns the number of characters that are capital letters.

   2. capitalize accepts a string of words, then returns the string with the first letter in each
      word capitalized.  A word starts after a space (or spaces).
      HINT: toUpperCase will only change a string, so use a string of length 1 at start of words

   3. reverse accepts a string, then returns the same string in reverse order
      HINT: build the new string like in alphabetize (or yesterday's noVowels)

   YOU ARE NOT ALLOWED TO CHANGE THE MAIN PROGRAM (except for commenting out code).
*/
import java.awt.*;
import hsa.Console;

public class HJ_InClass2b
{
    static Console c;
    //***************************numCaps method*********************
    public static int numCaps (String message)
    {
	int counter = 0; //number of caps
	char[] letters = message.toCharArray (); //turn message into char array
	for (int i = 0 ; i < letters.length ; i++) //for every number in the array
	{
	    if (letters [i] <= 90 && letters [i] >= 65) //if it is a capital
	    {
		counter++; //increment number of caps
	    }
	}
	return counter; //return value
    }


    //***************************capitalize method*********************
    public static String capitalize (String message)
    {
	boolean start = true;
	String capitalized = "";
	char[] letters = message.toCharArray (); //array of characters
	for (int i = 0 ; i < letters.length ; i++)
	{
	    if (start && letters [i] >= 97 && letters [i] <= 122) //if lowercase
	    {
		letters [i] -= 32; //make uppercase
	    }
	    capitalized += letters [i] + ""; //concatenate to return string
	    if (letters [i] == ' ') //if it is a space
	    {
		start = true; //true if it is
	    }
	    else
	    {
		start = false; //not space
	    }
	}

	return capitalized; //return value
    }

 
    //***************************reverse method*********************
    public static String reverse (String message)
    {
	String reversed = "";
	char[] letters = message.toCharArray (); //array of characters
	for (int i = letters.length - 1 ; i >=0 ; i--)
	{
	    reversed += letters[i] + "";
	}
	return reversed;
    }


    //***************************MAIN method*********************
    public static void main (String[] args)
    {
	c = new Console ();

	c.print ("\n\nEnter a multi-word message: ");
	String message = c.readLine ();

	c.println ("\nThe message has " + numCaps (message) + " capital letter(s).");

	c.println ("\nThe capitalized version is " + capitalize (message));

	c.println ("\nThe reversed version is " + reverse (message));
    } // main method
} // Inclass2 class


/* Sample run

   Enter a multi-word message: This is a test

   The message has 1 capital letter(s).

   The capitalized version is  This Is A Test

   The reversed version is tset a si sihT
*/
