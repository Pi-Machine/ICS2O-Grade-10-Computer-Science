/*HJ_PlayAudio.java
 
Playing an audio file
October 23, 2014

Must add JLayer.jar
In Ready to Program, File -> Preferences -> Java ->
Additional Class Path Directories: (add JLayer.jar file to path)
*/

import javazoom.jl.player.Player;
import java.io.FileInputStream;
public class HJ_PlayAudio
{
    public static void main (String[] args)
    {
	AudioPlayer bgm = new AudioPlayer ("bgm.mp3");
	bgm.play ();
    }
}

class AudioPlayer implements Runnable
{
    private Player player;
    private Thread thread;
    private boolean loop = false;
    private String fileName;
    public AudioPlayer (String s)
    {
	load (s);
    }


    public void load (String s)
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


    public void play ()
    {
	if (thread != null)
	    thread = null;
	if (thread == null)
	    load (fileName);
	thread.start ();
    }


    public void loop ()
    {
	loop = true;
	play ();
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
