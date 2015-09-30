package physics.simulator.projectile.motion;

import java.util.ArrayList;

public class BallContainer {

	private static double gravity = 9.81, accelerationInXDirection = 0;//static olup olmamasý ayarlanacak
	private ArrayList<BallOfProjectile> ballContainer;//static olup olmamasý ayarlanacak
	
	public BallContainer(){
		ballContainer = new ArrayList<BallOfProjectile>();
		
	}
	
	public void addBall(BallOfProjectile ball){
		ballContainer.add(ball);
	}
	
	public void deleteBall(BallOfProjectile ball){
		ballContainer.remove(ball);
	}
	
	public void deleteBall(int index){
		ballContainer.remove(index);
	}
	
	public void returnInitialPosition(){
		for(int i=0; i < numberOfBalls(); i++){
			ballContainer.get(i).setTrackOfBall(new ArrayList<BallOfProjectile>());
		}
	}
	
	public BallOfProjectile getBall(int index){
		return ballContainer.get(index);
	}
	
	public int numberOfBalls(){
		return ballContainer.size();
	}
	
	//Setter and Getter Methods
	public ArrayList<BallOfProjectile> getBallContainer() {
		return ballContainer;
	}

	public void setBallContainer(ArrayList<BallOfProjectile> ballContainer) {
		this.ballContainer = ballContainer;
	}

	public static double getGravity() {
		return gravity;
	}

	public static void setGravity(double gravity) {
		BallContainer.gravity = gravity;
	}

	public static double getAccelerationInXDirection() {
		return accelerationInXDirection;
	}

	public static void setAccelerationInXDirection(double accelerationInXDirection) {
		BallContainer.accelerationInXDirection = accelerationInXDirection;
	}
}
