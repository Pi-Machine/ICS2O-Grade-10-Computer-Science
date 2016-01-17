// The "PrintOutputb" class.
import java.awt.*;
import hsa.Console;

public class PrintOutputb
{
    static Console c;           // The output console
    
    public static void main (String[] args)
    {
	c = new Console ();
	
	c.print("Hello. " + "How are you today?");
    } // main method
} // PrintOutputb class
