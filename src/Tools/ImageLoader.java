package Tools;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * Imageloader class
 * This class contains tools for loading images
 *
 * @author Davy Raitt
 */

public class ImageLoader {
	
	public static BufferedImage loadImage ( String path ) {
		try
		{
			return ImageIO.read ( ImageLoader.class.getResource ( path ) );
		} catch ( IOException e )
		{
			System.out.println ( "Er gaat iets mis bij het laden!!" );
			e.printStackTrace ( );
			System.exit ( 1 );
			
		}
		return null;
	}
}
