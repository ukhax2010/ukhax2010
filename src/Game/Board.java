package Game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Vector;
import java.util.Random;

public class Board extends JPanel implements ActionListener
{
	public static final int WIDTH = 500;
    public static final int HEIGHT = 500;
    private final int NUM_ENEMIES = 5;
    private Random rand = new Random();
    private Timer t = new Timer(50, this);
    private ImageCache cache = new ImageCache();
    public Player player = new Player (100.0, 100.0, cache.loadImage("Resources/Images/guyred.png"));
    private Vector <Sprite> Sprites = new Vector <Sprite>();
    
    public Board()
    {
        Sprites.add(player);
        for (int i=0; i<NUM_ENEMIES; i++)
        {
        	Enemy enemy = new Enemy(rand.nextInt(300) + 100, rand.nextInt(300) + 100, cache.loadImage("Resources/Images/redeyes.png"), player);
        	Sprites.add(enemy);
        }
        setSize(WIDTH, HEIGHT);
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        setVisible(true);
        t.start();
    }
   
    public void paint(Graphics g)
    {
        super.paint(g);
    	setBackground(Color.white);
        if(player.isAlive())
        {
	        for (int i=0; i<Sprites.size(); i++)
	        {
	        	Sprites.get(i).draw(g);
	        }
        }
        else
        {
        	setBackground(Color.gray);
        	g.drawString("Game Over", 100, 100);
        }
    }
   
    public void actionPerformed(ActionEvent e)
    {
    	for(int i = 0; i < Sprites.size(); i++)
    	{
    		Sprites.get(i).move();
    	}
        repaint();
    }
}