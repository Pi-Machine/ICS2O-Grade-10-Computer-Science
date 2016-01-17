/* 
Sep 10 14
ICS2D3
MenuDemo - HJ_Set02
Demonstrating the use of a menu*/
import java.awt.*;
import hsa.Console;

public class HJ_Set02
{
  static Console c;           // The output console
  
  //***********************************Fieldwidths*************************
  public static void Fieldwidths()
  {
    c.clear();
    c.print("Hello",6);
    c.print("Hello",6);
    c.print("Hello",6);
    c.print("Hello");
    c.println();
    c.println();
    c.println("1234567890123456789012345678901234567890");
    c.print("Hello",12);
    c.print("Hello",12);
    c.print("Hello");
  }
  
  //***********************************Music*************************
  public static void Music()
  {
    c.clear();
    c.println("123456789012345");
    c.println("  Rock and Roll");
    c.println("      Metal");
    c.println();
    c.println("    The Blues");
  }
  
  //***********************************NameAndAddress*************************
  public static void NameAndAddress ()
  {
    c.clear();
    c.println("\tNAME AND ADDRESS");
    c.println();
    c.println("\t ");
    c.println("\t10 Don Mills Road");
    c.println("\tToronto");
    c.println("\tOntario");
    c.println("\tM2H 2C3");
  }
  
  //***********************************PrintName*************************
  public static void PrintName ()
  {
    c.clear();
  }
  
  //***********************************PrintOutput*************************
  public static void PrintOutput ()
  {
    c.clear();
    c.println("12345678901234567890");
    c.print("Hello ");
    c.println("How are you");
  }
  
  //***********************************PrintOutputb*************************
  public static void PrintOutputb ()
  {
    c.clear();    
    c.print("Hello. " + "How are you today?");
  }
  
  //***********************************Shopping************************* 
  public static void Shopping ()
  {
    c.clear();    
    c.print("I am going ");
    c.println("to the");
    c.println("shopping mall.");
    c.println("");
    c.println("There is no bus");
    c.println("may I have a lift?");
  }
  
  //***********************************VirusWarning*************************
  public static void VirusWarning ()
  {
    c.clear();
    c.println("\t" + "WARNING" + "\n");
    c.println("\tPossible virus detected \n\tReboot and run antivirus software");
  }
  
  //***********************************Menu Program Here*************************
  public static void main (String[] args)
  {
    c = new Console ();
     //variable delclaration for user's choice
    int choice;
    do
    {
      //Prompting for choice
      
      c.println ();
      c.println ("Choose from the following menu\n");
      c.println ("Enter 1, 2, 3, 4, 5, 6, 7, 8");
      c.println ("1 - Fieldwidths Program");
      c.println ("2 - Music Program");
      c.println ("3 - NameAndAddress Program");
      c.println ("4 - PrintName Program");
      c.println ("5 - PrintOutput Program");
      c.println ("6 - PrintOutputb Program");
      c.println ("7 - Shopping Program");
      c.println ("8 - VirusWarning Program");
      
      c.println ();
      c.println ("Enter 0 to exit");
      choice = c.readInt ();
      
      if (choice == 1)
      {
	Fieldwidths();
      }
      else if (choice == 2)
      {
	Music();
      }
      else if (choice == 3)
      {
	NameAndAddress();
      }
      else if (choice == 4)
      {
	PrintName();
      }
      else if (choice == 5)
      {
	PrintOutput();
      }
      else if (choice == 6)
      {
	PrintOutputb();
      }
      else if (choice == 7)
      {
	Shopping();
      }
      else if (choice == 8)
      {
	VirusWarning();
      }
      c.print ("Press enter to continue");
      c.getChar ();      
      c.clear ();
      //This will loop until user enters 0
    }   
    while (choice != 0);
    c.println ("The program has terminated");
  } // main method
} // HJ_Set02 class
