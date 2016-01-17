// The "PrintOutput" class.
import java.awt.*;
import hsa.Console;

public class PrintOutput
{
    static Console c;           // The output console
    
    public static void main (String[] args)
    {
 c = new Console ();
 
 c.println("12345678901234567890");
 c.print("Hello ");
 c.println("How are you");
    } // main method
} // PrintOutput class
