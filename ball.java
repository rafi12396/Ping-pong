package gam;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

import javax.sound.sampled.AudioInputStream;

public class Ball {

	public int x,y,bWidth=20,Bheight=20,motX=5,motY=5,speed=5,totHits;
	Random random;
	
	
	public Ball(MainClass mn){
		x=mn.width/2-10;
		y=mn.height/2-10;
		totHits=0;
	}
	
	public void update(Stick playerOne, Stick playerTwo) {
		
		
		if(x<playerOne.x+playerOne.sWidth && x>playerOne.x && (y<=(playerOne.y+playerOne.sHeight) && y>=playerOne.y))
		{
			motX=Math.abs(motX);
			totHits++;
			if(totHits/4>=1)
			{
				motX++;
				totHits=0;
			}
		}
		
		else if(x<playerOne.x)
		{
			totHits=0;
			motX=5;
			motY=5;
			x=MainClass.mn.width/2-10;
			y=MainClass.mn.height/2-10;
			playerTwo.score++;
		}
		
		else if(x+bWidth<playerTwo.x+playerTwo.sWidth && x+bWidth>playerTwo.x && (y<=(playerTwo.y+playerTwo.sHeight) && y>=playerTwo.y))
		{
			totHits++;
			motX=-motX;
			if(totHits/4>=1)
			{
				motX--;
				totHits=0;
			}
		}
		
		else if(x>playerTwo.x+playerTwo.sWidth)
		{
			totHits=0;
			motX=5;
			motY=5;
			x=MainClass.mn.width/2-10;
			y=MainClass.mn.height/2-10;
			playerOne.score++;
		}
		
		if(y==0)
		{
			motY=Math.abs(motY);
		}
		else if(y+Bheight==MainClass.mn.height)
		{
			motY=-motY;
		}
		
		x+=motX;
		y+=motY;
		
	}

	public void drawBall(Graphics g) {
		
		g.setColor(Color.CYAN);
		g.fillOval(x, y, bWidth, Bheight);
	}
}
