package physics.simulator.collision;

import java.awt.Color;
import java.awt.Graphics;

import physics.simulator.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;


public class BallTest {
	
	public static void main (String[] args)
	{
		JFrame frame = new JFrame("Collision");
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Ball ball1 = new Ball(10, new Vector(100,150), new Vector(5,4));
		ball1.setBallColor(Color.GRAY);
		Ball ball2 = new Ball(10, new Vector(200,50), new Vector(2,1));
		Ball ball3 = new Ball(10, new Vector(140,100), new Vector(1,2));
		Ball ball4 = new Ball(20, new Vector(300,90), new Vector(2,1));
		ball4.setBallColor(Color.GREEN);
		Ball ball5 = new Ball(5, new Vector(300,50), new Vector(4,1));
		ball5.setBallColor(Color.blue);
		ball3.setBallColor(Color.orange);
		BallPanel panel = new BallPanel();
		FunctionPanel panel1 = new FunctionPanel();
//		panel.addBall(ball1);
//		panel.addBall(ball2);
//		panel.addBall(ball3);
//		panel.addBall(ball4);
//		panel.addBall(ball5);
//		 panel.resetTimer();
		panel.playTimer();
		frame.getContentPane().add(panel1);
		double b;
//		b = Math.cos(Math.PI/2);
//		System.out.println ((b));
//		System.out.println (2 * Math.acos(b));
		frame.pack();
		
		frame.setVisible(true);
	}
}
