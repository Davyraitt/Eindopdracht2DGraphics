package Tools;

import java.io.*;

/**
 * Utils class
 * This class contains some versatile utilities
 *
 * @author Davy Raitt
 */

public class Utils {
	
	public static String loadFileAsString ( String path ) { // reads a file and loads it as a full string
		StringBuilder builder = new StringBuilder ( );
		
		try
		{
			BufferedReader br = new BufferedReader ( new FileReader ( path ) );
			String line;
			while ( ( line = br.readLine ( ) ) != null )
				builder.append ( line + "\n" );
			
			br.close ( );
		} catch ( IOException e )
		{
			e.printStackTrace ( );
		}
		
		return builder.toString ( );
	}
	
	public static int parseInt ( String number ) { // [parses a string to a integer
		try
		{
			return Integer.parseInt ( number );
		} catch ( NumberFormatException e )
		{
			e.printStackTrace ( );
			return 0;
		}
	}
}
