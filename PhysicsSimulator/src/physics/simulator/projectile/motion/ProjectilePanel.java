package physics.simulator.projectile.motion;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;

public class ProjectilePanel extends JPanel{

	enum TypeOfClick {add, edit, delete};
	
	private final int DELAY = 10;
	
	private BallContainer container;
	private boolean isItStart, showVelocity, showAcceleration, showBallTrack;
	private Timer timer;
	private double time;
	private TypeOfClick typeOfClick;
	private Point startPointOfTheBall;
	
	public ProjectilePanel(){
		container = new BallContainer();
		isItStart = false;
		showVelocity = true;
		showAcceleration = true;
		showBallTrack = true;
		timer = new Timer(DELAY, new TimerListener());
		time = 0;
		typeOfClick = TypeOfClick.add;
		
		ClickListener clickListener = new ClickListener();		
		addMouseListener(clickListener);
		addMouseMotionListener(clickListener);
		
		setBackground(Color.YELLOW);
	}
	
	public void paintComponent (Graphics page){
		super.paintComponent(page);
		
		if(isItStart)
			for( int i=0; i < container.numberOfBalls(); i++){
				container.getBall(i).draw(page, time);
				if(showBallTrack){
					container.getBall(i).drawTrack(page);
				}
			}
		else
			for( int i=0; i < container.numberOfBalls(); i++){
				container.getBall(i).draw(page);
			}
		
		if(showVelocity){
			
		}
	}
	
	public void returnInitialPosition(){
		container.returnInitialPosition();
	}
	
	private class TimerListener implements ActionListener{
		public void actionPerformed(ActionEvent arg0) {
			time = time + (double)DELAY / 1000;
			repaint();
		}
	}
	
	private class ClickListener implements MouseListener, MouseMotionListener
	{
		public void mousePressed(MouseEvent event) {
			if(!isItStart){
				if (typeOfClick == TypeOfClick.add){
					startPointOfTheBall = event.getPoint();
					BallOfProjectile ball = new BallOfProjectile(startPointOfTheBall);
					container.addBall (ball);
					repaint();
				}
				
				else if (typeOfClick == TypeOfClick.edit){
					
				}
				
				else if (typeOfClick == TypeOfClick.delete){
					for(int i=0; i < container.numberOfBalls(); i++)
						if(container.getBall(i).DoesItContainThePoint(event.getPoint())){
							container.deleteBall(i);
							i = container.numberOfBalls();
							repaint();
						}
				}
			}
		}
		
		public void mouseClicked(MouseEvent e) {}
		public void mouseEntered(MouseEvent e) {}
		public void mouseExited(MouseEvent e) {}
		public void mouseReleased(MouseEvent e) {}
		public void mouseDragged(MouseEvent event) {
			if(typeOfClick == TypeOfClick.add && container.numberOfBalls() > 0 && !isItStart){
				Point endPoint = event.getPoint();
				container.getBall(container.numberOfBalls()-1).setVelocityX(endPoint.getX() - startPointOfTheBall.getX());
				container.getBall(container.numberOfBalls()-1).setVelocityY(endPoint.getY() - startPointOfTheBall.getY());
			}
		}
		public void mouseMoved(MouseEvent e) {}
	}

	//Settter and Getter Methods
	public boolean isItStart() {
		return isItStart;
	}

	public void setItStart(boolean isItStart) {
		this.isItStart = isItStart;
	}

	public double getTime() {
		return time;
	}

	public void setTime(double time) {
		this.time = time;
	}

	public TypeOfClick getTypeOfClick() {
		return typeOfClick;
	}

	public void setTypeOfClick(String typeOfClick) {
		this.typeOfClick = TypeOfClick.valueOf(typeOfClick);
	}

	public Timer getTimer() {
		return timer;
	}

	public boolean isShowVelocity() {
		return showVelocity;
	}

	public void setShowVelocity(boolean showVelocity) {
		this.showVelocity = showVelocity;
	}

	public boolean isShowAcceleration() {
		return showAcceleration;
	}

	public void setShowAcceleration(boolean showAcceleration) {
		this.showAcceleration = showAcceleration;
	}

	public boolean isShowBallTrack() {
		return showBallTrack;
	}

	public void setShowBallTrack(boolean showBallTrack) {
		this.showBallTrack = showBallTrack;
	}
	
}
