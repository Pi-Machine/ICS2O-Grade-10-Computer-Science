/* The "HJ_ArrayExtra" class.
 
EXTRA Assignment - Arrays
November 12, 2014
*/
import java.awt.*;
import hsa.Console;

public class HJ_ArrayExtra
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
	int[] neworder = new int [values.length]; //new array
	int[] first, second;
	if (values.length % 2 == 0)
	{
	    first = new int [values.length / 2]; //divide into two arrays
	    second = new int [values.length / 2];
	}
	else
	{
	    first = new int [values.length / 2 + 1]; //divide into two arrays
	    second = new int [values.length / 2];
	}
	for (int i = 0 ; i < first.length ; i++)
	{
	    first [i] = values [i]; //fill first array
	}
	for (int i = 0 ; i < second.length ; i++)
	{
	    second [i] = values [i + first.length]; //fill second array
	}

	for (int i = 0 ; i < neworder.length ; i++)
	{
	    if (i % 2 == 0)
	    {
		neworder [i] = first [i / 2];
	    }
	    else
	    {
		neworder [i] = second [i / 2];
	    }
	}
	return neworder;
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
	int list[] = {3, 23, 234, 173, 245, 34, 45};  // change this list for testing purposes

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


