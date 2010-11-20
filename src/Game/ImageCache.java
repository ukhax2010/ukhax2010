package Game;

import java.awt.GraphicsConfiguration;
import java.awt.GraphicsEnvironment;
import java.awt.Transparency;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import javax.imageio.ImageIO;

// Idea borrowed from Kevin Glass at
// http://www.cokeandcode.com/info/tut2d.html
public class ImageCache
{
	private HashMap<String, BufferedImage> images;
	
	public ImageCache()
	{
		images = new HashMap<String, BufferedImage>();
	}
	public BufferedImage loadImage(String path)
	{
		if(images.containsKey(path))
		{
			return images.get(path);
		}
		else
		{
			BufferedImage source = null, image = null;
			try
			{
				source = ImageIO.read(new File(path));
			}
			catch(IOException e)
			{
				System.out.println("Could not find image at " + path);
				System.exit(0);
			}
			GraphicsConfiguration gc = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDefaultConfiguration();
			image = gc.createCompatibleImage(source.getWidth(), source.getHeight(), Transparency.BITMASK);
			image.getGraphics().drawImage(source, 0, 0, null);
			images.put(path, image);
			return image;
		}
	}
}
