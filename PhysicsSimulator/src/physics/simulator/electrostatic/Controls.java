package physics.simulator.electrostatic;

import javax.swing.*;

import physics.simulator.Vector;

import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Controls extends JPanel implements SimulatorView{
	JTextField CoorX,CoorY,MagCharge,EditCharge;
	JButton Delete, Add, ChargeMag, Reset;
	SimulatorModel sim;
	double mag,x,y;
	JLabel Selected;
	public Controls(SimulatorModel sim){
		this.sim = sim;
		setLayout( new BoxLayout( this, BoxLayout.Y_AXIS));
		setBackground(Color.cyan);
		
		Delete = new JButton( "DELETE OBJECT");
		Add = new JButton   ( "   ADD OBJECT   ");
		ChargeMag = new JButton( "Edit Charge");
		Reset = new JButton("RESET");

		
		Selected = new JLabel("Object selected to delete");
		CoorX = new JTextField( "Coordinate x",1);
		CoorY = new JTextField( "Coordinate y",1);
		MagCharge = new JTextField( "Amount of charge",1);
		EditCharge = new JTextField ( "Edit Charge", 1);
		
		Delete.addMouseListener( new MyMouseListener());
		Add.addMouseListener( new MyMouseListener());
		ChargeMag.addMouseListener( new MyMouseListener());
		Reset.addMouseListener( new MyMouseListener());
		
		CoorX.addActionListener( new MyActionListener());
		CoorY.addActionListener( new MyActionListener());
		MagCharge.addActionListener( new MyActionListener());
		
		
		add( Box.createRigidArea( new Dimension (0, 10)));
		
		add(MagCharge);
		add(CoorX);
		add(CoorY);
		add(Add);
		
		add( Box.createRigidArea( new Dimension (0, 270)));
		add(Selected);
		add(EditCharge);
		add(ChargeMag);
		add(Delete);
		add(Reset);
		add( Box.createRigidArea( new Dimension (0, 10)));
		
	}
	public class MyMouseListener implements MouseListener{
     	public void mouseClicked(MouseEvent e){
     		if( e.getSource() == Add){
				sim.addCharge( new Charge( Integer.valueOf(MagCharge.getText()), new Vector(Integer.valueOf(CoorX.getText()),Integer.valueOf(CoorY.getText()))));
     		}
     		if( e.getSource() == Delete){
     			sim.deleteCharges();
     		}
     		if( e.getSource() == ChargeMag){
     			for( int i = 0; i < sim.getCharges().size(); i++){
     				if( ((Charge)(sim.getCharges().get(i))).getDelete() == true) {
     					((Charge)sim.getCharges().get(i)).setCharge( Integer.valueOf(EditCharge.getText()));
     				}
     			}
     			sim.moveCharges(0,0);
     		}
     		if( e.getSource() == Reset){
     			sim.reset();
     		}
     	}

		public void	mouseEntered(MouseEvent e){
		}

		public void	mouseExited(MouseEvent e){
		}

		public void	mousePressed(MouseEvent e){
		}

		public void	mouseReleased(MouseEvent e){
		}
    }
    public class MyActionListener implements ActionListener{
		public void actionPerformed( ActionEvent e){
			if( e.getSource() == MagCharge){
				
			} else if( e.getSource() == CoorX){
				
			} else {
				
			}
		}
    }
    public void updateView( SimulatorModel s){
    	    	
    	if( s.getSelectedDelete() == 0){
    		ChargeMag.setEnabled(false);
    		Delete.setEnabled(false);
    	}else{
    		ChargeMag.setEnabled(true);
    		Delete.setEnabled(true);
    	}
    		
    			
    	Selected.setText("Object selected " + sim.getSelectedDelete());
    }
}
