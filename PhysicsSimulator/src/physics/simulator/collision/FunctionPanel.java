package physics.simulator.collision;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import physics.simulator.Vector;
import javax.swing.*;


public class FunctionPanel extends JPanel{

	//properties
	JTextField mass, XVelocity, YVelocity, X,Y;
	JLabel massL,XVelocityL,YVelocityL, XL,YL;
	JPanel textFieldPanel;
	JButton reset,addBall,pause,play;
	BallPanel ballPanel;
	JPanel btnPanel;
	public FunctionPanel()
	{
		setLayout(new BorderLayout());
		//initializing
		ballPanel = new BallPanel();
		
		btnPanel = new JPanel();
		btnPanel.setLayout(new GridLayout(9,1));
		
		textFieldPanel = new JPanel();
		textFieldPanel.setLayout(new GridLayout(5,2));
		
		mass = new JTextField(3);
		massL = new JLabel("Mass");
		textFieldPanel.add(massL);
		textFieldPanel.add(mass);
		
		XVelocity = new JTextField(3);
		XVelocityL = new JLabel("X velocity");
		textFieldPanel.add(XVelocityL);
		textFieldPanel.add(XVelocity);
		
		YVelocity = new JTextField(3);
		YVelocityL = new JLabel("Y velocity");
		textFieldPanel.add(YVelocityL);
		textFieldPanel.add(YVelocity);
		
		X= new JTextField(3);
		XL = new JLabel("X position");
		textFieldPanel.add(XL);
		textFieldPanel.add(X);
		
		Y= new JTextField(3);
		YL = new JLabel("Y position");
		textFieldPanel.add(YL);
		textFieldPanel.add(Y);
		
		reset = new JButton("Reset");
		addBall = new JButton("Add Ball");
		pause = new JButton("Pause");
		play = new JButton("Play");
		
		//wiring up
		reset.addActionListener(new MyActionListener());
		addBall.addActionListener(new MyActionListener());
		pause.addActionListener(new MyActionListener());
		play.addActionListener(new MyActionListener());
		
		//adding the properties to panel
		btnPanel.add(textFieldPanel);
		btnPanel.add(addBall);
		btnPanel.add(pause);
		btnPanel.add(play);
		btnPanel.add(reset);
		add(ballPanel, BorderLayout.CENTER);
		add(btnPanel,BorderLayout.EAST);
	}
	
	public class MyActionListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) 
		{
			double x,y, m, vx,vy;
		
			if(e.getSource() == addBall)
			{
				try{
					m= Double.parseDouble(mass.getText());
				}catch(NumberFormatException error){
					m = 0;
				}
				
				try{
					vx = Double.parseDouble(XVelocity.getText());
				}catch(NumberFormatException error){
					vx = 0;
				}
				
				try{
					vy = Double.parseDouble(YVelocity.getText());
				}catch(NumberFormatException error){
					vy = 0;
				}
				
				try{
					x = Double.parseDouble(X.getText());
				}catch(NumberFormatException error){
					x = 0;
				}
				
				try{
					y = Double.parseDouble(Y.getText());
				}catch(NumberFormatException error){
					y = 0;
				}
				
				ballPanel.addBall(new Ball(m,new Vector(x,y), new Vector(vx,vy)));
				repaint();
			}
			
			if(e.getSource() == pause)
				ballPanel.pauseTimer();
			
			if (e.getSource() == play)
				ballPanel.playTimer();
			
			if(e.getSource() == reset){
				ballPanel.resetTimer();
				repaint();
			}
		}
		
		
	
}}
