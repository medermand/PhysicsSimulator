package physics.simulator.projectile.motion;

import java.awt.*;
import java.util.ArrayList;
import physics.simulator.Vector;

public class BallOfProjectile{

	//This Values are initial values, won't change according to time
	private int radiusOfBall;
	private double angle, velocity;
	private double velocityX, velocityY;
	private Vector location; //Location Of Center
	private ArrayList<BallOfProjectile> trackOfBall;//will keep the movements of balls at any time
	
	//for track of ball
	public BallOfProjectile(){
		
		radiusOfBall = 10;
		angle = 0;
		velocity = 0;
		velocityX = 0;
		velocityY = 0;
		location = new Vector();
		trackOfBall = new ArrayList<BallOfProjectile>();
	}
	
	//Main Ball
	public BallOfProjectile(Point point){
		super();
		radiusOfBall = 10;
		angle = 0;
		velocity = 0;
		location = new Vector();
		location.setCartesian(point.x, point.y);
		trackOfBall = new ArrayList<BallOfProjectile>();
	}
	
	public void draw( Graphics page ){
		page.setColor(Color.BLUE);
		page.fillOval((int)location.getX()-radiusOfBall, (int)location.getY()-radiusOfBall, radiusOfBall*2, radiusOfBall*2);
	}
	
	public void draw( Graphics page, double time ){
		BallOfProjectile drawnBall = getBall(time);
		page.setColor(Color.BLUE);
		page.fillOval((int)drawnBall.location.getX()-radiusOfBall, (int)drawnBall.location.getY()-radiusOfBall, radiusOfBall*2, radiusOfBall*2);//Hafif bir yuvarlama var
	}
	
	public void drawTrack(Graphics page){
		for(int i=0; i < trackOfBall.size(); i++)
			page.drawOval((int)(trackOfBall.get(i).location.getX()), (int)(trackOfBall.get(i).location.getY()), 1, 1);
	}
	
	public boolean DoesItContainThePoint(Point point){
		Vector tempLocation = new Vector();
		tempLocation.setCartesian(point.x, point.y);
		if( Vector.distance(location, tempLocation) <= radiusOfBall )
			return true;
		else
			return false;
	}
	
	public BallOfProjectile getBall( double time){
		BallOfProjectile nextBall = new BallOfProjectile();
		double xOfLocation, yOfLocation;
		
		xOfLocation = location.getX() + velocity * Math.cos(angle) * time + 0.5 * BallContainer.getAccelerationInXDirection() * time * time;
		yOfLocation = location.getY() + velocity * Math.sin(angle) * time + 0.5 * BallContainer.getGravity() * time * time;
		nextBall.location.setCartesian(xOfLocation, yOfLocation);
		
		nextBall.velocityX = velocityX + BallContainer.getAccelerationInXDirection() * time;
		nextBall.velocityY = velocityY + BallContainer.getGravity() * time * time;
		
		trackOfBall.add(nextBall);
		
		return nextBall;
	}
	
	public void setAngle(double angle) {
		this.angle = angle;
		velocityX = velocity * Math.cos(angle);
		velocityY = velocity * Math.sin(angle);
	}
	
	public void setVelocity(double velocity) {
		this.velocity = velocity;
		velocityX = velocity * Math.cos(angle);
		velocityY = velocity * Math.sin(angle);
	}
	
	public void setVelocityX(double velocityX) {
		this.velocityX = velocityX;
		velocity = Math.sqrt(Math.pow(velocityX, 2) + Math.pow(velocityY, 2));
		angle = Math.atan2(velocityY, velocityX);
	}
	
	public void setVelocityY(double velocityY) {
		this.velocityY = velocityY;
		velocity = Math.sqrt(Math.pow(velocityX, 2) + Math.pow(velocityY, 2));
		angle = Math.atan2(velocityY, velocityX);
	}
	
	//Setter and Getter Methods
	public int getRadiusOfBall() {
		return radiusOfBall;
	}
	public void setRadiusOfBall(int radiusOfBall) {
		this.radiusOfBall = radiusOfBall;
	}
	public double getAngle() {
		return angle;
	}
	
	public double getVelocity() {
		return velocity;
	}
	
	public double getVelocityX() {
		return velocityX;
	}

	public double getVelocityY() {
		return velocityY;
	}
	
	public ArrayList<BallOfProjectile> getTrackOfBall() {
		return trackOfBall;
	}
	public void setTrackOfBall(ArrayList<BallOfProjectile> trackOfBall) {
		this.trackOfBall = trackOfBall;
	}
	
}
