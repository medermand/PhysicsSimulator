package physics.simulator.projectile.motion;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import physics.simulator.MainMenu;

public class ControlPanelOfProjectile extends JPanel{

	private final int widthOfProjectile = 300, widthOfControl = 100, height = 300;
	private ProjectilePanel projectilePanel;
	private JPanel controlPanel, typeOfClickPanel, checkBoxPanel, buttonPanel;
	private JRadioButton add, edit, delete;
	private JCheckBox velocity, acceleration, ballTrack;
	private JButton startAndStop;
	
	public ControlPanelOfProjectile(){
		//VARIABLES
		projectilePanel = new ProjectilePanel();
		controlPanel = new JPanel();
		typeOfClickPanel = new JPanel();
		checkBoxPanel = new JPanel();
		buttonPanel = new JPanel();
		add = new JRadioButton("Add", true);
		edit = new JRadioButton("Edit");
		delete = new JRadioButton("Delete");
		velocity = new JCheckBox("Velocity");
		acceleration = new JCheckBox("Acceleration");
		ballTrack = new JCheckBox("Track Of Balls");
		startAndStop = new JButton("START");
		
		//typeOfClickPanel
		ButtonGroup typeOfClickGroup = new ButtonGroup();
		typeOfClickGroup.add(add);
		typeOfClickGroup.add(edit);
		typeOfClickGroup.add(delete);

		TypeOfClickListener clickListener = new TypeOfClickListener();
		add.addActionListener(clickListener);
		edit.addActionListener(clickListener);
		delete.addActionListener(clickListener);
		
		typeOfClickPanel.setLayout(new GridLayout(3,1));
		typeOfClickPanel.add(add);
		typeOfClickPanel.add(edit);
		typeOfClickPanel.add(delete);
		
		//CheckBoxPanel
		CheckBoxListener checkListener = new CheckBoxListener();
		velocity.addActionListener(checkListener);
		acceleration.addActionListener(checkListener);
		ballTrack.addActionListener(checkListener);
		
		checkBoxPanel.setLayout(new GridLayout(3,1));
		checkBoxPanel.add(velocity);
		checkBoxPanel.add(acceleration);
		checkBoxPanel.add(ballTrack);
		
		//ButtonPanel
		StartButtonListener buttonListener = new StartButtonListener();
		startAndStop.addActionListener(buttonListener);
		
		buttonPanel.setLayout(new BorderLayout());
		buttonPanel.add(startAndStop);
		
		controlPanel.setLayout(new BoxLayout(controlPanel, BoxLayout.Y_AXIS));
		controlPanel.add(typeOfClickPanel);
		controlPanel.add(checkBoxPanel);
		controlPanel.add(buttonPanel);
		
		setLayout(new BorderLayout());
		add(projectilePanel, BorderLayout.CENTER);
		add(controlPanel, BorderLayout.EAST);
		
		setBackground(Color.GRAY);//AYARLANACAK
	}
	
	private class CheckBoxListener implements ActionListener{
		public void actionPerformed(ActionEvent event){
			if(velocity.isSelected()){
				
			}
			if(acceleration.isSelected()){
				
			}
			if(ballTrack.isSelected())
				projectilePanel.setShowBallTrack(true);
			else
				projectilePanel.setShowBallTrack(false);
		}
	}
	
	private class StartButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			if(projectilePanel.isItStart()){
				projectilePanel.setItStart(false);
				startAndStop.setText("START");
				projectilePanel.getTimer().stop();
				projectilePanel.setTime(0);
				projectilePanel.returnInitialPosition();
				projectilePanel.repaint();
			}
			else{
				projectilePanel.setItStart(true);
				startAndStop.setText("STOP");
				projectilePanel.getTimer().start();
			}
		}
		
	}
	
	private class TypeOfClickListener implements ActionListener{
		public void actionPerformed(ActionEvent event) {
			Object source = event.getSource();
			if(source == add)
				projectilePanel.setTypeOfClick("add");
			else if(source == edit)
				projectilePanel.setTypeOfClick("edit");
			else if(source == delete)
				projectilePanel.setTypeOfClick("delete");
		}
	}
}
