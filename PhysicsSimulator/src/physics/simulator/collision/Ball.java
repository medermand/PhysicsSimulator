package physics.simulator.collision;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.*;

import physics.simulator.Vector;

public class Ball {
	
	//properties
	private double mass;
	private Vector location;
	
	ArrayList<Point> position;//this is for getting every point of the ball as it changes its position to draw its track
	private final  double defaultMass = 15;//needs to be changed
	private double radiusOfBall;
	private Vector velocity;
	private Color ballColor;
	
	//constructors
	
	//this is default constructor
	public Ball()
	{
		
		mass = defaultMass;
		radiusOfBall = mass;
		location = new Vector(0,0);
		velocity = new Vector(0,0);
		position = new ArrayList<Point>();
		position.add(new Point(0,0));
	}
	
	public Ball(double mass, Vector location, Vector velocity)
	{
		
		this.mass = mass;
		radiusOfBall = 3 * mass;
		this.location = location;
		this.velocity = velocity;
		position = new ArrayList<Point>();
		ballColor = Color.BLUE;
		
//		position.add(new Point()); 
	}
	
	public void updateLocation(){
		setPosition(new Point((int)location.x, (int)location.y));
		setLocation(location.x + getSpeedX(), location.y + getSpeedY());
	}
	
	//METHOD
	
	//MUTATORs

	
	public void setLocation(double x, double y)
	{
		location.setCartesian(x, y);
//		System.out.println ("setLocation working ");
	}
	public void setPosition(Point p)
	{
		position.add(p);
	}
	
	public void setSpeedX( double x)
	{
		velocity.setCartesian(x, getSpeedY());
	}
	
	public void setSpeedY( double y)
	{
//		System.out.println ("SetSpeedY");
		velocity.setCartesian(getSpeedX(), y);
	}
	
	public void setSpeed(double x, double y)
	{
//		System.out.println ("SetSpeed");
		velocity.setCartesian(x, y);
//		System.out.println (getSpeedX()+ " " + getSpeedY());
	}
	
	public void setBallColor(Color c)
	{
		ballColor = c;
	}
	
	//ACCESSORS
	public Vector getLocation()
	{
		return location;
	}
	public double getLocationX()
	{
		return location.getX();
	}
	
	public double getLocationY()
	{
		return location.getY();
	}
	
	public double getBallRadius()
	{
		return radiusOfBall;
	}
	//this method is to return X or Y components of the velocity
	public Vector getVelocity()
	{
		return velocity;
	}
	
	public double getSpeed()
	{
		return velocity.getR();
	}
	public double getSpeedX()
	{
		return velocity.getX();
	}
	public double getSpeedY()
	{
		return velocity.getY();
	}
	
	public double getMass()
	{
		return mass;
	}
	
	public void draw(Graphics g)
	{
		int r = (int)radiusOfBall;
		g.setColor(ballColor);
		g.fillOval((int)location.getX() - r, (int)location.getY() - r, 2*r, 2*r);
//		int length = position.size();
//		int[] X = new int[length];
//		int[] Y = new int[length];
//		for (int i = 0; i < length; i++)
//		{
//			X[i] = position.get(i).x;
//			Y[i] = position.get(i).y;
//		}
//		g.drawPolyline(X, Y, length);
	}	
		
}

