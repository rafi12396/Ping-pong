package gam;

import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class MainPanelClass extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		MainClass.mn.moveScreen((Graphics2D)g);
	}
	
}
