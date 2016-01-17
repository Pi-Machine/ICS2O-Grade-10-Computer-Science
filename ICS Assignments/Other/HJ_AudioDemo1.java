// The "HJ_AudioDemo1" class.
import java.awt.*;
import hsa.Console;
import sun.audio.*;
import java.io.*;

public class HJ_AudioDemo1
{
    static Console c;           // The output console

    public static void main (String[] args)throws Exception
    {
	c = new Console ();
	// open the sound file as a Java input stream
	InputStream in = new FileInputStream ("beep.wav");

	// create an audiostream from the inputstream
	AudioStream audioStream = new AudioStream (in);

	// play the audio clip with the audioplayer class
	AudioPlayer.player.start (audioStream);
	// Place your program here.  'c' is the output console
    } // main method
} // HJ_AudioDemo1 class
