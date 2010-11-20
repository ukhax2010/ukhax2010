package Game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

public class Player extends Sprite implements KeyListener 
{

	int hp, maxhp;
	Image image;
	Rectangle bounds;
	
	public Player(double x, double y, BufferedImage image)
	{
		super(x, y, image);

		maxspeed = 9;
		maxhp = 10;
		hp = 10;
		bounds = new Rectangle(image.getWidth(null), image.getHeight(null));
	}
	
	public void decrementHP()
	{
		--hp;
	}
	
	public void draw(Graphics g)
	{
		super.draw(g);
		g.setColor(Color.green);
        if(hp < 0.67 * maxhp) 
        	g.setColor(Color.yellow);
        if(hp < 0.33 * maxhp) 
        	g.setColor(Color.red);
        g.fillRect(0,0, (int)(500 * ((double)hp / maxhp)), 10);
	}
	
	public void move()
	{
		if((x > 0 && dx < 0) || (x < Board.WIDTH - 50 && dx > 0))
			x += dx;
		if((y > 0 && dy < 0) || (y < Board.HEIGHT - 50 && dy > 0))
			y += dy;
	}
	
	public boolean isAlive()
	{
		return hp > 0;
	}

	public void keyPressed(KeyEvent e) 
	{	
		int keyCode = e.getKeyCode();
		switch(keyCode)
		{
			case KeyEvent.VK_LEFT:
				dx = -20;
				break;
			case KeyEvent.VK_A:
				dx = -20;
				break;
			case KeyEvent.VK_RIGHT:
				dx = 20;
				break;
			case KeyEvent.VK_D:
				dx = 20;
				break;
			case KeyEvent.VK_UP:
				dy = -20;
				break;
			case KeyEvent.VK_W:
				dy = -20;
				break;
			case KeyEvent.VK_DOWN:
				dy = 20;
				break;
			case KeyEvent.VK_S:
				dy = 20;
				break;
		}
	} 
	
	public void keyReleased(KeyEvent e)	
	{	
		int keyCode = e.getKeyCode();
		switch(keyCode)
		{
			case KeyEvent.VK_LEFT:
				dx = 0;
				break;
			case KeyEvent.VK_A:
				dx = 0;
				break;
			case KeyEvent.VK_RIGHT:
				dx = 0;
				break;
			case KeyEvent.VK_D:
				dx = 0;
				break;
			case KeyEvent.VK_UP:
				dy = 0;
				break;
			case KeyEvent.VK_W:
				dy = 0;
				break;
			case KeyEvent.VK_DOWN:
				dy = 0;
				break;
			case KeyEvent.VK_S:
				dy = 0;
				break;
		}
	} 
	
	public void keyTyped(KeyEvent e) 
	{
		if (e.getKeyCode() == KeyEvent.VK_ESCAPE) 
		{
			System.exit(0);
		}
	}
}
