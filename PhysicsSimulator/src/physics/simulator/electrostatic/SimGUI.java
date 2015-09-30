package physics.simulator.electrostatic;

import java.util.ArrayList;

import javax.swing.*;

import physics.simulator.Vector;

import java.awt.*;
import java.awt.event.*;

public class SimGUI extends JPanel implements SimulatorView{
	SimulatorModel s;
	public SimGUI( SimulatorModel s){
		this.s = s;
		
		addMouseListener( new MyMouseListener());
		setPreferredSize( new Dimension( 500,500));
		setBackground( Color.yellow);
	}
	
	public void updateView( SimulatorModel s){
    	repaint();
    }
    public void paintComponent( Graphics g){
    	super.paintComponent(g);
    	if( s.getCharges().size() != 0){
    		for(int i = 0; i < s.getVectors().size(); i++){
    			((Vector)(s.getVectors().get(i))).printVector( ((Vector)(s.getVectors().get(i))), g);		
    		}	
    	}
    	
    	for( int i = 0; i < s.getCharges().size(); i++){
    		((Charge)(s.getCharges().get(i))).paint(g);
    	}
    	g.drawLine( 10, 15, 4990, 15);
    	g.drawLine( 10, 10, 10, 4990);
    	
    	for( int i = 60; i < 1000; i += 50){
   			g.drawLine(i, 15, i, 12);
    		g.drawLine(10, i, 7, i);
    		g.drawString( Integer.toString(i), i, 10);
    		g.drawString( Integer.toString(i), 13, i);
    	}
    
    }
	public class MyMouseListener implements MouseListener, MouseMotionListener{
     	public void mouseClicked(MouseEvent e){
     		for( int i = 0; i < (s.getCharges()).size(); i++){
				if( ((Charge)(s.getCharges().get(i))).contains(e.getX(),e.getY()) == true){
					boolean del;
					if( ((Charge)(s.getCharges().get(i))).getDelete() == false)
						del = true;
					else
						del = false;
					((Charge)(s.getCharges().get(i))).setDelete(del);
				}
				s.moveCharges(e.getX(),e.getY());
			}
			double poten = 0;
			for( int k = 0; k < s.getCharges().size(); k++){
    			poten += ((Charge)(s.getCharges().get(k))).calculatePotantial( new Vector(e.getX(), e.getY()));
    		}
			setToolTipText( "x = " + Integer.toString( e.getX()) + " y = "+ Integer.toString( e.getY()) + " potential " + poten);
     	}

		public void	mouseEntered(MouseEvent e){
			
		}

		public void	mouseExited(MouseEvent e){
		}

		public void	mousePressed(MouseEvent e){
			for( int i = 0; i < (s.getCharges()).size(); i++){
				if( ((Charge)(s.getCharges().get(i))).contains(e.getX(),e.getY()) == true){
					((Charge)(s.getCharges().get(i))).setMove(true);
					break;
				}
			}
		}

		public void	mouseReleased(MouseEvent e){
			s.moveCharges(e.getX(),e.getY());
			
	    	for( int i = 0; i < (s.getCharges()).size(); i++){
				if( ((Charge)(s.getCharges().get(i))).contains(e.getX(),e.getY()) == true){
					((Charge)(s.getCharges().get(i))).setMove(false);
					
				}
			}
			
		}
	    public void	mouseDragged(MouseEvent e){
	    	
	    }

		public void	mouseMoved(MouseEvent e){
			
		}
    }
}
