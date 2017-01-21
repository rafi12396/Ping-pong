package gam;

import java.awt.*;

import javax.swing.*;

import com.sun.org.apache.xml.internal.resolver.helpers.PublicId;
public class Stick{

	public int x,y,sHeight=120,sWidth=25,speed=15,paddleNum;
	public int score=0;
	Color cr;
	
	public Stick(MainClass mn,int pl) {
		if(pl==1)
		{
			paddleNum=1;
			x=30;
			y=mn.height/2-sHeight/2;
			cr=Color.RED;
		}
		else
		{
			paddleNum=2;
			x=mn.width-50;
			y=mn.height/2-sHeight/2;
			cr=Color.GREEN;
		}
	}
	
	public void move(boolean up) {
		if(up)
		{
			
			if(y-speed>0)
			{
				y=y-speed;
			}
			else
			{
				y=0;
			}
		}
		else
		{
			if(y+sHeight+speed<MainClass.mn.height)
			{
				y=y+speed;
			}
			else
			{
				y=MainClass.mn.height-sHeight-speed;
			}
		}
	}
	
	
	public void drawStick(Graphics g){
		//super.paint(g);
		g.setColor(cr);
		g.fillRect(x, y, sWidth, sHeight);
	}
}
