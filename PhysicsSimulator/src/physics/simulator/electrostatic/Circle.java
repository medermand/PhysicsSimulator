package physics.simulator.electrostatic;

import java.awt.*; //For draw method

/**
 * Circle
 *
 * @author Furkan Alan
 * @version 1.00 2014/3/20
 */
 
public class Circle {
	
	//Constants
	final double pi = 3.14;
	
	private int x;
	private int y;
	
	//Variables
	int radius;
	boolean IsSelected, charge;
	
	//Constructor
	public Circle ( int radius ){
		this.radius = radius;
		x = 0;
		y = 0;
		IsSelected = false;
	}
	
	public Circle( int x, int y, boolean charge){
		radius = 20;
		this.x = x;
		this.y = y;
		IsSelected = false;
		this.charge = charge;
	}
	
	//Draw method
	public void draw (Graphics page)
	{
		page.drawOval (x-radius, y-radius, 2*radius, 2*radius);
	}
	
	//get radius
	public int getRadius(){
		return radius;
	}
	
	//getArea
	public double getArea(){
		return pi*radius*radius;
	}
	
	//getSelected
	public boolean getSelected(){
		return IsSelected;
	}
	
	//setSelected
	public void setSelected( boolean IsSelected ){
		this.IsSelected = IsSelected;
	}
	
	//contains
	public boolean contains( int x, int y){
		if( Math.sqrt((x-this.x)*(x-this.x) + (y-this.y)*(y-this.y)) <= radius)
			return true;
			
		else
			return false;		
	}
	public void paint( Graphics g){
    	
    	if( charge)
    		g.setColor( Color.red);
    	else
    		g.setColor( Color.blue);
    	g.fillOval( x, y, 20, 20 );
    	
    		
    	g.setColor( Color.white);
    	if( charge){
    		g.drawLine( x + 5, y + 10, x + 15, y + 10);
    		g.drawLine( x + 10 , y + 5, x + 10, y + 15);
    	}
    	else{
    		g.drawLine(  x + 5, y + 10, x + 15, y + 10);
    	}
   		g.setColor( Color.black);
   		
    }
	
}
