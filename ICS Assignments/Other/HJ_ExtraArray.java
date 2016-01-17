/*HJ_ExtraArray.java
November 11, 2014
EXTRA Assignment dealing with ARRAYS
*/
import java.awt.*;
import hsa.Console;

public class HJ_ExtraArray
{
    static Console c;           // The output console

    public static void print (int[] array) //print method prints the array
    {
	for (int i = 0 ; i < array.length ; i++)
	{
	    c.print (array [i]);
	    //print the element at index i
	    
	    if (i != array.length - 1)
	    {
		c.print (", ");
		//print a comma and space after every element except the last
	    }
	}
    }


    public static void main (String[] args)
    {
	c = new Console ();
	c.print ("How many elements in array?");
	int limit = c.readInt ();
	//input for the limit of the array

	if (limit != 0)
	{
	    int[] array = new int [limit];
	    //declaring the array

	    c.print ("Now enter the " + limit + " elements of the array. Press enter after each one.");
	    for (int i = 0 ; i < limit ; i++)
	    {
		array [i] = c.readInt ();
	    }
	    //input the values into the array
	}
	// Place your program here.  'c' is the output console
    } // main method
} // HJ_ExtraArray class
