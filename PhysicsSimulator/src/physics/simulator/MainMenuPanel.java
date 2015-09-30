package physics.simulator;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import physics.simulator.collision.FunctionPanel;
import physics.simulator.projectile.motion.ControlPanelOfProjectile;

public class MainMenuPanel extends JPanel {

	private MainMenuPanel thisPanel;
	private JButton projectile, collision, electrostatic;
	
	public MainMenuPanel(){
		thisPanel = this;
		projectile = new JButton("Projectile Motion");
		collision = new JButton("Collision");
		electrostatic = new JButton("Electrostatic");
		
		ButtonListener buttonListener = new ButtonListener();
		projectile.addActionListener(buttonListener);
		collision.addActionListener(buttonListener);
		electrostatic.addActionListener(buttonListener);
		
		setLayout(new GridLayout(3,1));
		this.add(projectile);
		this.add(collision);
		this.add(electrostatic);
		
		setPreferredSize(new Dimension(MainMenu.getWidthOfPanel(), MainMenu.getHeightofpanel()));
	}
	
	private class ButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent event){
			Object source = event.getSource();
			if(source == projectile){
				MainMenu.getFrame().add(new ControlPanelOfProjectile());
				thisPanel.setVisible(false);
			}
			else if(source == collision){
				MainMenu.getFrame().getContentPane().add(new FunctionPanel());
				thisPanel.setVisible(false);
			}
			else if(source == electrostatic){
				MainMenu.getFrame().getContentPane().add(new ControlPanelOfProjectile());
				thisPanel.setVisible(false);
			}
		}
	}
}
