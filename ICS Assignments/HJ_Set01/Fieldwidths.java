// The "Fieldwidths" class.
import java.awt.*;
import hsa.Console;

public class Fieldwidths
{
    static Console c;           // The output console
    
    public static void main (String[] args)
    {
 c = new Console ();
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
    } // main method
} // Fieldwidths class
