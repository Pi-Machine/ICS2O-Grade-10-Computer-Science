// The "VirusWarning" class.
import java.awt.*;
import hsa.Console;

public class VirusWarning
{
    static Console c;           // The output console
    
    public static void main (String[] args)
    {
	c = new Console ();
	c.println("\t" + "WARNING" + "\n");
	c.println("\tPossible virus detected \n\tReboot and run antivirus software");
    } // main method
} // VirusWarning class
