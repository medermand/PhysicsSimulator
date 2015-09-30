package physics.simulator.electrostatic;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Menu extends JFrame{
	SimulatorModel s;
	SimulatorFrame frame;
	JButton Back, ElecSim;
	public Menu( String title){
		setTitle( title);
		JPanel menu = new JPanel();
		menu.setPreferredSize( new Dimension( 250,250));
		ElecSim = new JButton("Electrostatic");
		ElecSim.addActionListener( new MyActionListener());
		Back = new JButton("Back");
		Back.addActionListener( new MyActionListener());
		JPanel back = new JPanel();
		back.add(Back);
		menu.add( ElecSim);
		menu.setPreferredSize( new Dimension(500,500));
		s = new SimulatorModel();
		
		Controls con = new Controls(s);
		SimGUI gui = new SimGUI(s);
		
		s.addView(con);
		s.addView(gui);
		frame = new SimulatorFrame( "Simulator", gui, con);
		frame.add(back, BorderLayout.NORTH);
		frame.setVisible(false);
		
		getContentPane().add(menu);
		setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		pack();
		setVisible( true);
	}
	public class MyActionListener implements ActionListener{
		public void actionPerformed( ActionEvent e){
			if (e.getSource() == ElecSim){
				frame.setVisible(true);
				setVisible(false);
			}
			if (e.getSource() == Back){
				frame.setVisible(false);
				setVisible(true);
			}	
			
		}
	}
}

