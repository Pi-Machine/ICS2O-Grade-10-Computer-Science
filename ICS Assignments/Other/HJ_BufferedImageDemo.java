/* The "HJ_BufferedImageDemo" class.
 
DEMO for BufferedImage and Graphics2D circumvent the issue of flashing graphics
November 18, 2014
*/
import java.awt.*;
import java.awt.image.BufferedImage; //Remember to import this!
import hsa.Console;

public class HJ_BufferedImageDemo
{
    static Console c;           // The output console

    public static void main (String[] args) throws Exception
    {
	c = new Console ();

	//IMPORTANT - Declaring the BufferedImage object; think of this as a normal Image
	BufferedImage image = new BufferedImage (700, 500, BufferedImage.TYPE_INT_ARGB);
	//IMPORTANT - Draw everything with "graphics." instead of "c."
	Graphics2D graphics = image.createGraphics ();

	for (int i = 0 ; i < 500 ; i++) //Before, this is flashy
	{
	    c.setColor (Color.white);
	    c.fillRect (0, 0, 700, 500); //a white background
	    c.setColor (Color.black);
	    c.fillRect (i, 100, 30, 30); //the black square
	    Thread.sleep (1);
	    c.clear ();
	}

	for (int i = 0 ; i < 500 ; i++) //After, this is not flashy
	{
	    graphics.setColor (Color.white);
	    graphics.fillRect (0, 0, 700, 500); //a white background
	    graphics.setColor (Color.black);
	    graphics.fillRect (i, 100, 30, 30); //the black square again
	    c.drawImage (image, 0, 0, null); //draw the bufferedImage
	    Thread.sleep (2);
	}
	// Place your program here.  'c' is the output console
    } // main method
} // HJ_BufferedImageDemo class
