package physics.simulator.collision;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import physics.simulator.Vector;

import javax.swing.*;


public class BallPanel extends JPanel{

	//properties
	private Timer timer;
	 ArrayList<Ball> balls;
	private Collision collision;
	
	//constructor
	public BallPanel()
	{
		//initializing
		balls = new ArrayList<Ball>();
		collision = new Collision(balls);
		collision.setSize(this);
		timer = new Timer(50, new TimerListener());
		
		//panel properties
		MyMouseListener mouseListener = new MyMouseListener();
		addMouseListener(mouseListener);
		this.addMouseMotionListener(mouseListener);
		setBackground(Color.GREEN);
		this.setPreferredSize(new Dimension(300,300));
	}
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		for(Ball i:balls)
			i.draw(g);
	}
	
	//methods
	public void addBall(Ball a)
	{
		balls.add(a);
	}
	
	public void pauseTimer()
	{
		timer.stop();
	}
	
	public void playTimer()
	{
		timer.start();
	}
	
	public void resetTimer()
	{
		balls = new ArrayList<Ball>();
		collision = new Collision(balls);
		collision.setSize(this);
	}
	
	//by using this method, I am going to make every two ball one collision and save them in collision arrayList, so that when
	//every actionPerformed is called, instead of looking every ball and creating collisions, just checks created collisions by this method
	private class TimerListener implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent event) 
		{
			collision.update();
			repaint();
		}
	}

	private class MyMouseListener implements MouseListener,MouseMotionListener
	{
		Ball ball;
		Point initial, end;
		
		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
	
		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
		}
	
		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
		}
	
		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			initial = e.getPoint();
			ball = new Ball (10,new Vector (initial.x, initial.y), new Vector ());
			
			
		}
	
		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			int deltaX, deltaY;
			
			end = e.getPoint();
			
			deltaX = initial.x - end.x;
			deltaY = initial.y- end.y;
			ball.setSpeed(deltaX / 10, deltaY /10);//if I directly set deltaX as a speedX then it is very fast for balls' velocity
			addBall(ball);
			repaint();
		}
	
		@Override
		public void mouseDragged(MouseEvent event) {
			// TODO Auto-generated method stub
			
		}
	
		@Override
		public void mouseMoved(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}
		
	}
}
