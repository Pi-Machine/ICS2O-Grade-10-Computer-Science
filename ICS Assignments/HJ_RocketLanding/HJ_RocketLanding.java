/* The "HJ_RocketLanding" class.
 
November 17, 2014
Rocket blasting off and then landing
*/
import java.awt.*;
import java.awt.image.BufferedImage;
import javax.swing.*;
import hsa.Console;
import sun.audio.*;
import javax.imageio.*;
import java.io.*;
import java.util.Random;

public class HJ_RocketLanding
{
    static Console c;           // The output console
    static Graphics2D graphics;
    static Random rand = new Random ();

    //*******************************Image Loading Method****************************
    public static Image loadImage (String name) throws Exception
    {
	Image img = ImageIO.read (new File (name));
	return img;
    }


    //*******************************Audio Method****************************
    public static void playAudio (String file) throws Exception //for .wav only
    {
	InputStream in = new FileInputStream (file);
	AudioStream as = new AudioStream (in);
	AudioPlayer.player.start (as);
    }


    //*******************************MAIN Method****************************
    public static void main (String[] args) throws Exception
    {
	c = new Console ();
	BufferedImage image = new BufferedImage (640, 480, BufferedImage.TYPE_INT_ARGB); //BufferedImage
	graphics = image.createGraphics (); //Graphics2D

	//initial scene
	Image rocket = loadImage ("rocketInit.png"); //loading the initial rocket
	Image place = loadImage ("place.jpg"); //loading the initial scence
	graphics.drawImage (place, 0, 0, null);
	graphics.drawImage (rocket, 250, 100, null);
	c.drawImage (image, 0, 0, null);

	//Countdown
	c.println ("Press any key to initiate countdown: "); //prompt for start of countdown
	c.getChar ();
	String[] nums = {"3.png", "2.png", "1.png"}; //"10.png", "9.png", "8.png", "7.png", "6.png", "5.png", "4.png", 
	for (int i = 0 ; i < 3 ; i++)
	{
	    graphics.drawImage (place, 0, 0, null);
	    graphics.drawImage (rocket, 250, 100, null);
	    graphics.drawImage (loadImage (nums [i]), rand.nextInt (450), rand.nextInt (250), null);
	    c.drawImage (image, 0, 0, null);
	    Thread.sleep (1000);
	}


	//explosion scene
	Image explosion = loadImage ("explosion.png"); //loading the explosion image
	rocket = loadImage ("rocketInitFire.png"); //changing the rocket so it has fire
	playAudio ("explosion.wav"); //playing explosion audio
	graphics.drawImage (explosion, 30, 50, null);
	c.drawImage (image, 0, 0, null);
	Thread.sleep (750);

	//launch
	for (int i = 0 ; i < 100 ; i++)
	{
	    graphics.drawImage (place, 0, 0, null);
	    graphics.drawImage (rocket, 250, 100 - (i * i * i * i) / 5000, null); //rocket take off speed
	    c.drawImage (image, 0, 0, null);
	}


	//flying through the space
	rocket = loadImage ("rocket1.png"); //changing the rocket
	place = loadImage ("space.jpg"); //changing the background
	Image wormhole = loadImage ("wormhole.png"); //loading the wormhole
	Image missile = loadImage ("missile.png"); //loading a missile
	int missileX = 500; //determine missile locations
	int missileX2 = 500;
	for (int x = 0 ; x < 740 ; x += 2)
	{
	    int y = (int) (Math.sin (Math.toRadians (x)) * 125 + 125); //sine path of the rocket
	    graphics.drawImage (place, 0, 0, null); //epic space background
	    graphics.drawImage (wormhole, 350, 125, null); //draw the moving rocket
	    graphics.drawImage (rocket, x / 3, y, null); //draw the wormhole

	    if (y < 200 && x > 200) //draw a missile low
	    {
		graphics.drawImage (missile, missileX, 300, null);
		missileX -= 10;
	    }
	    if (y > 200 && x > 200) //draw a missile high
	    {
		graphics.drawImage (missile, missileX2, 100, null);
		missileX2 -= 30;
	    }

	    c.drawImage (image, 0, 0, null);
	}

	//Into the wormhole
	Thread.sleep (300);
	playAudio ("wormhole.wav");
	Thread.sleep (1200);
	graphics.drawImage (place, 0, 0, null); //epic space background
	graphics.drawImage (wormhole, 350, 125, null); //draw the wormhole
	Thread.sleep (1000);

	//landing
	Image flag = loadImage ("canada.png"); //Canada!
	place = loadImage ("place.jpg"); //load ending scene
	for (int i = 0 ; i < 150 ; i++)
	{
	    graphics.drawImage (place, 0, 0, null);
	    graphics.drawImage (rocket, i, 2 * i, null); //rocket landing speed
	    c.drawImage (image, 0, 0, null);
	}
	Thread.sleep(300);
	graphics.drawImage (flag, 50, 100, null);
	c.drawImage (image, 0, 0, null);


	// Place your program here.  'c' is the output console
    } // main method
} // HJ_RocketLanding class
