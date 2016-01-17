/* 
Oct 24 14
ICS2O3
HJ_BlastOff
Blast Off Program with Sound*/
import java.awt.*;

import javazoom.jl.player.Player;
import java.io.FileInputStream;
import hsa.Console;

public class HJ_BlastOff
{
    static Console c; // The output console

    // ***********************************with DoWhile Loop*************************
    public static void DoWhileLoop ()
    {
	c.clear ();
	int num = 10; //initialization of the number
	do
	{
	    c.println (num);
	    num--; //decrement num
	    try
	    {
		Thread.sleep (300); //delay
	    }
	    catch (InterruptedException e)
	    {
		e.printStackTrace ();
	    }
	}
	while (num > 0);
    }


    // ***********************************with While Loop*************************
    public static void WhileLoop ()
    {
	c.clear ();
	int num = 10; //initialization of the number
	while (num > 0)
	{
	    c.println (num);
	    num--; //decrement num
	    try
	    {
		Thread.sleep (300); //delay
	    }
	    catch (InterruptedException e)
	    {
		e.printStackTrace ();
	    }
	}
    }


    // ***********************************with for Loop*************************
    public static void ForLoop ()
    {
	c.clear ();
	for (int i = 10 ; i > 0 ; i--)
	{
	    c.println (i);
	    try
	    {
		Thread.sleep (300); //delay
	    }
	    catch (InterruptedException e)
	    {
		e.printStackTrace ();
	    }
	}
    }



    // ***********************************Menu Program Here*************************
    public static void main (String[] args)
    {
	c = new Console ();
	// variable declaration for user's choice
	int choice;
	do
	{
	    // Prompting for choice

	    c.println ();
	    c.println ("Choose from the following menu\n");
	    c.println ("Enter 1, 2, or 3");
	    c.println ("1 - With DoWhile Loop");
	    c.println ("2 - With While Loop");
	    c.println ("3 - With for Loop");

	    c.println ();
	    c.println ("Enter 0 to exit");
	    choice = c.readInt ();

	    if (choice == 1)
	    {
		DoWhileLoop ();
	    }
	    else if (choice == 2)
	    {
		WhileLoop ();
	    }
	    else if (choice == 3)
	    {
		ForLoop ();
	    }

	    c.println ("Blast off!"); // blast off output
	    AudioPlayer bgm = new AudioPlayer ("Rocket.mp3");
	    bgm.play (); //play the audio

	    c.println ();
	    try
	    {
		Thread.sleep (700); //delay
	    }
	    catch (InterruptedException e)
	    {
		e.printStackTrace ();
	    }
	    c.print ("Press enter to continue");
	    c.getChar ();
	    c.clear ();
	    bgm.stop();
	    // This will loop until user enters 0
	}
	while (choice != 0);
	c.println ("The program has terminated");
    } // main method
} // HJ_BlastOff class



class AudioPlayer implements Runnable //AudioPlayer class
{
    private Player player;
    private Thread thread;
    private boolean loop = false;
    private String fileName;
    public AudioPlayer (String s)
    {
	load (s);
    }


    public void load (String s) //load the file
    {
	fileName = s;
	try
	{
	    player = new Player (new FileInputStream (s));
	    thread = new Thread (this);
	}
	catch (Exception e)
	{
	    e.printStackTrace ();
	}
    }

    public void play ()//play file
    {
	if (thread != null)
	    thread = null;
	if (thread == null)
	    load (fileName);
	thread.start ();
    }


    public void stop ()
    {
	loop = false;
	thread = null;
	player.close ();
    }


    public void run ()
    {
	do
	{
	    try
	    {
		player.play ();
	    }
	    catch (Exception e)
	    {
		e.printStackTrace ();
	    }
	    if (loop)
		load (fileName);
	}
	while (loop);
    }
}
