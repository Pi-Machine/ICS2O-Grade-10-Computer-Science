/* The "HJ_ArrayExtra" class.
 
EXTRA Assignment - Arrays
November 12, 2014
*/
import java.awt.*;
import hsa.Console;
import java.util.Arrays;

public class HJ_ArrayExtra2
{
    static Console c;           // The output console


    //**********************************print method*****************************************
    public static void print (int[] values)
    {
	for (int i = 0 ; i < values.length ; i++) //loop through each value in array
	{
	    c.print (values [i]); //print the value
	    if (i != values.length - 1)
	    {
		c.print (", "); //print comma and space after every number except last one
	    }
	}
    }


    //**********************************neworder method*****************************************
    public static int[] neworder (int[] values)
    {
	int[] neworder = new int [values.length]; //initialize the duplicate
	int counter = 0; //counter for the array
	for (int i = 0 ; i < values.length ; i++)
	{
	    neworder [i] = values [i]; //assigning values to the duplicate
	}
	for (int i = 0 ; i < values.length ; i += 2) //even indexes
	{
	    neworder [i] = values [counter]; //assign the values
	    counter++; //incrementing the counter
	}
	for (int i = 1 ; i < values.length ; i += 2) //odd indexes
	{
	    neworder [i] = values [counter]; //assign the values
	    counter++; //incrementing the counter
	}
	return neworder; //return value
    }


    //**********************************twodigits method*****************************************
    public static int[] twodigits (int[] values)
    {
	int[] temp = new int [values.length]; //the new temp array
	int counter = 0; //counter for temp array
	for (int i = 0 ; i < values.length ; i++)
	{
	    if (values [i] / 10 > 0 && values [i] / 10 < 10) //if two digits
	    {
		temp [counter] = values [i]; //add to temp array
		counter++; //increment counter
	    }
	}
	int[] twodigits = new int [counter]; //final array to return
	for (int i = 0 ; i < counter ; i++)
	{
	    twodigits [i] = temp [i]; //adding
	}
	return twodigits;
    }


    //**********************************main method*****************************************
    public static void main (String[] args)
    {
	c = new Console ();
	int list[] = {3, 23, 234, 173, 245, 34, 45, 20, 60};  // change this list for testing purposes

	c.print ("Here is the original list: ");
	print (list);

	c.print ("\nThe re-ordered list: ");
	int changed[] = neworder (list);
	print (changed);

	c.print ("\nThe 2-digit numbers: ");
	int some[] = twodigits (changed);
	print (some);
	// Place your program here.  'c' is the output console
    } // main method
} // HJ_ArrayExtra class


