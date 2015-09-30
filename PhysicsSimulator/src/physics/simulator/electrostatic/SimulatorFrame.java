package physics.simulator.electrostatic;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SimulatorFrame extends JFrame {
		public SimulatorFrame( String title, JComponent centerComponent )//constructors
	{
		this( title, centerComponent, null);
	}

	public SimulatorFrame( String title, JComponent centerComponent, JComponent eastComponent)
	{
		setTitle( title);
		setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE);

		if ( centerComponent != null) add( centerComponent, BorderLayout.CENTER);
		if ( eastComponent != null)   add( eastComponent,   BorderLayout.EAST);

		setResizable(false);
		pack();
		setVisible( true);
	}
	
}
