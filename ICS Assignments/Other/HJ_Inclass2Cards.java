/*
 
InClass2Cards
November 28, 2014

For this in-class assignment, you are to complete the program by writing the methods getCard and
   quality.

   I would suggest that you write near-empty methods with return statements first to get the
   program running, then work on the problems themselves.

   YOU ARE NOT ALLOWED TO CHANGE THE MAIN PROGRAM (except for testing).
*/
import java.awt.*;
import hsa.Console;

public class HJ_Inclass2Cards
{
    static Console c;

    // getCard simply accepts a low and high integer and returns a random integer in that range
    // 4 marks
    // ***************************getCard method***********************
    public static int getCard (int low, int high)
    {
	int value = (int) (Math.random () * (high - low)) + low; //calculating random card
	return value; //return value
    }


    // show accepts an integer and displays the card value A (for 1), 2, 3, ... 10,
    // J (for 11), Q (for 12), K (for 13)
    // 5 marks

    // ***************************show method***********************
    public static void show (int value)
    {
	if (value <= 13 && value >= 1)
	{
	    if (value == 1)
	    {
		c.print (" A"); //ace if 1
	    }
	    else if (value == 11)
	    {
		c.print (" J"); //jack if 11
	    }
	    else if (value == 12)
	    {
		c.print (" Q"); //queen if 12
	    }
	    else if (value == 13)
	    {
		c.print (" K"); //king if 13
	    }
	    else
	    {
		c.print (" " + value); //# value if not face card
	    }

	}
	else
	{
	    c.print ("\nInvalid num"); //otherwise invalid number
	}
    }


    // quality accepts 3 integers and returns whether you have a pair, 3 of a kind or nothing
    // 6 marks
    // BONUS: add an option that identifies a straight (run of 3) - efficiency counts
    // 2 marks

    // ***************************quality method***********************
    public static String quality (int card1, int card2, int card3)
    {
	if (card1 == card2 && card1 == card3)
	{
	    return "3 of a kind"; //if all cards are equal then it is 3 of a kind
	}
	else if (card1 == card2 || card2 == card3 || card1 == card3)
	{
	    return "a pair"; //if 2 cards are equal, then there is a pair
	}
	else
	{
	    int[] cards = {card1, card2, card3}; //create an array of cards
	    int low = 0;
	    int middle = 0;
	    int high = 0;
	    for (int i = 0 ; i < cards.length ; i++)
	    {
		if (cards [i] <= cards [low]) //setting the lowest index
		{
		    middle = low;
		    low = i;
		}
		else if (cards [i] >= cards [high]) //setting the highest index
		{
		    middle = high;
		    high = i;
		}
		else
		{
		    middle = i; //setting the middle index
		}
	    }
	    if (cards [high] - cards [middle] == 1 && cards [middle] - cards [low] == 1)
	    {
		return "a straight"; //if the cards are consecutive, then it is a straight
	    }
	    else
	    {
		return "nothing"; //otherwise, it is nothing
	    }
	}

    }


    // ***************************main method***********************
    public static void main (String[] args)
    {
	c = new Console ();
	char again;

	do
	{
	    c.print ("\n\nHere is your 3-card hand: ");
	    int card1 = getCard (10, 13), card2 = getCard (10, 13), card3 = getCard (10, 13);

	    show (card1);
	    show (card2);
	    show (card3);

	    c.print ("\nYou have " + quality (card1, card2, card3));

	    c.print ("\nDo you want to play again?");
	    again = c.getChar ();
	}
	while (again == 'y');
    } // main method
} // Inclass2Nov06 class


/* Sample run

   Here is your 3-card hand: K J J
   You have a pair
   Do you want to play again?

   Here is your 3-card hand: 3 2 8
   You have nothing
   Do you want to play again?

   Here is your 3-card hand: Q Q Q
   You have 3 of a kind
   Do you want to play again?

   Here is your 3-card hand: J 9 10     BONUS ONLY
   You have a straight
   Do you want to play again?


*/
