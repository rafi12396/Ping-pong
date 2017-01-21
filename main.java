package gam;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class MainClass implements KeyListener,ActionListener{

	public static MainClass mn;
	public Ball ball;
	public int width=800,height=600;
	public MainPanelClass mainPanel;
	public Stick playerOne,playerTwo;
	public JFrame mainFrame;
	public boolean up,down,w,s;
	public int gameStatus=0;//0=MENU,  1=start,   2=pause
	//JPanel mainPanel,nrtPanel;
	
	public MainClass(){
		
		Timer timer=new Timer(20, this);
		
		mainFrame=new JFrame("PING-PONG");
		mainPanel=new MainPanelClass();
		mainFrame.setSize(width+15,height+35);
		mainFrame.setVisible(true);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.add(mainPanel);
		mainFrame.addKeyListener(this);
		
		mainFrame.setResizable(false);
		mainFrame.setLocationRelativeTo(null);
	
		
		timer.start();
		start();
	}
	
	public void  start() {
		playerOne=new Stick(this,1);
		playerTwo=new Stick(this,2);
		ball=new Ball(this);
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		mn=new MainClass();
	}
	
	
	public void update() {
			
		if(up)
		{
			playerTwo.move(true);
		}
		
		if(down)
		{
			playerTwo.move(false);
		}
		
		if(w)
		{
			playerOne.move(true);
		}
		
		if(s)
		{
			playerOne.move(false);
		}
		ball.update(playerOne,playerTwo);
		//ball.move();
		
	}
	
	public void moveScreen(Graphics2D g) {
		// TODO Auto-generated method stub
		g.fillRect(0, 0, width, height);
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g.setStroke(new BasicStroke(5f));
		g.setFont(new Font("TimesRoman",Font.PLAIN,24));
		g.setColor(Color.RED);
		g.drawString(""+playerOne.score, 10, 20);
		g.setColor(Color.GREEN);
		g.drawString(""+playerTwo.score, width-20, 20);
		g.setColor(Color.GRAY);
		g.drawLine(width/2, 0, width/2, height);
		g.drawOval(width/2-40, height/2-40, 80, 80);	
		ball.drawBall(g);
		playerOne.drawStick(g);
		playerTwo.drawStick(g);
		
		/*else if(gameStatus==0)
		{
			g.setColor(Color.YELLOW);
			g.setStroke(new BasicStroke(5f));
			g.setFont(new Font("TimesRoman",Font.PLAIN,24));
			g.drawString("PRESS SPACE TO STAR/PAUSE THE GAME", width/2, height/2);
		}*/
	}
	public void keyPressed(KeyEvent ev) {
		// TODO Auto-generated method stub
		if(ev.getKeyCode()==KeyEvent.VK_UP)
		{
			System.out.println("ru");
			up=true;
		}
		else if(ev.getKeyCode()==KeyEvent.VK_DOWN)
		{
			System.out.println("rd");
			down=true;
		}
		
		if(ev.getKeyCode()==KeyEvent.VK_W)
		{
			System.out.println("lu");
			w=true;
		}
		
		else if(ev.getKeyCode()==KeyEvent.VK_S)
		{
			System.out.println("ld");
			s=true;
		}
		
		
	}
	public void keyReleased(KeyEvent ev) {
		// TODO Auto-generated method stub
		
		if(ev.getKeyCode()==KeyEvent.VK_UP)
		{
			System.out.println("rc");
			up=false;
		}
		else if(ev.getKeyCode()==KeyEvent.VK_DOWN)
		{
			System.out.println("rc");
			down=false;
		}
		
		if(ev.getKeyCode()==KeyEvent.VK_W)
		{
			System.out.println("lc");
			w=false;
		}
		
		else if(ev.getKeyCode()==KeyEvent.VK_S)
		{
			System.out.println("lc");
			s=false;
		}
		
	}
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		update();
		mainPanel.repaint();
	}

}
