package Game;

import java.awt.Container;

import javax.swing.JFrame;

public class GameFrame extends JFrame 
{
    public GameFrame()
    {
        setSize(Board.WIDTH, Board.HEIGHT);
        setTitle("Appropriate name");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Container pane = getContentPane();
        Board board = new Board();
        pane.add(board);
        pane.validate();
        pack();
        addKeyListener(board.player);
        setResizable(false);
        setVisible(true);
    }
   
    public static void main(String[] args) 
    {
        new GameFrame();
    }
}