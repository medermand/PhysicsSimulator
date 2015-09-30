package physics.simulator.electrostatic;

/**
 * @(#)Charge.java
 *
 *
 * @author 
 * @version 1.00 2014/2/23
 */
import java.awt.*;

import physics.simulator.Vector;
public class Charge{
	
	public final double k = 8.9875517873681764 * Math.pow(10,9);
	public double charge;
	boolean move, delete;
	Vector location;
	//Constructer
    public Charge(double charge,Vector location) {
    	this.charge = charge;
    	this.location = location;
    	move = false;
    	delete = false;
    }
    //Accessor Methods
    public double getCharge(){
		return this.charge;
	}
    public Vector getLocation(){
		return this.location;
    }
    public void setCharge( double charge){
    	this.charge = charge;
    }
    public void setLocation( Vector Location){
		this.location = location;
    }
	public void setLocation( double x, double y){
		location.setCartesian(x,y);
	}
    public double calculatePotantial(Vector point){
    	// V = k * q / d
    	return k * this.charge / Vector.distance(point,this.location );
    }
    public Vector calculateElectricField(Vector point){
    	//create new Vector object to represent electric field
    	Vector electricFieldVector = new Vector();
    	//equalization to displacement vector
    	electricFieldVector = Vector.vectorSubtract(point,this.location);
    	// Calculation electric field by The Coulomb Law
    	// E = k * q * vector of d / d^3
    	double factor = k * this.charge/Math.pow(Vector.distance(this.location,point),3);
    	//final stage of calculation
    	//multibly displacement with factor
    	return Vector.product(factor,electricFieldVector);	
    }
  
    public void paint( Graphics g){
    	
    	if( getDelete()){
    		g.fillOval( (int)location.getX() - 11, (int)location.getY() - 11, 22, 22 );
    	}
    	if( charge > 0)
    		g.setColor( Color.red);
    	else
    		g.setColor( Color.blue);
    	g.fillOval( (int)location.getX() - 10, (int)location.getY() - 10, 20, 20 );
    	
    		
    	g.setColor( Color.white);
    	if( charge > 0){
    		g.drawLine( (int)location.getX() - 5, (int)location.getY(), (int)location.getX() + 5,(int)location.getY());
    		g.drawLine( (int)location.getX() , (int)location.getY()- 5, (int)location.getX(),(int)location.getY() + 5);
    	}
    	else{
    		g.drawLine( (int)location.getX() - 5, (int)location.getY(), (int)location.getX() + 5,(int)location.getY());
    	}
   		g.setColor( Color.black);
   		
    }
    public void setMove( boolean b){
    	move = b;
    }
    public boolean getMove(){
    	return move;
    }
    public void setDelete( boolean b){
    	delete = b;
    }
    public boolean getDelete(){
    	return delete;
    }
    
    public boolean contains(double x, double y)
    {
       if( (int)(Math.sqrt((Math.pow(x - location.getX(),2) + Math.pow(y - location.getY(),2)))) <= 10 )
           return true;
       return false;
    }
    
    
}