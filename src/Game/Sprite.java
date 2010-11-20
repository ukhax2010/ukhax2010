package Game;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public abstract class Sprite 
{
	double x, y, dx, dy, maxspeed;
	double xOffset, yOffset;
	int width, height;
	boolean visible = false;
	boolean alive = false;
	BufferedImage image = null;
	public Sprite(double x, double y, BufferedImage image)
	{
		this.x = x;
		this.y = y;
		this.image = image;
		width = image.getWidth();
		height = image.getHeight();
		xOffset = width / 2.0;
		yOffset = height / 2.0;
		alive = true;
		visible = true;
		dx = 0;
		dy = 0;
	}
	
	public abstract void move();
	
	// Might be useful? I was under the impression that
	// x & y were the top left corner of the sprites, but
	// now I'm not sure =/
	public Point getCenter()
	{
		return new Point((int)(x + xOffset), (int)(y + yOffset));
	}
	
	public Rectangle getBounds()
	{
		return new Rectangle((int)x, (int)y, width, height);
	}
	
	public void draw(Graphics g)
	{
        g.drawImage(image, (int)x, (int)y, null);
	}
}
