package physics.simulator.electrostatic;

import java.util.*;

import physics.simulator.Vector;


public class SimulatorModel {
	
	private ArrayList<Charge> charges;
	private ArrayList<Vector> vectors;
	private ArrayList<SimulatorView> views;
	
	public SimulatorModel(){
		charges = new ArrayList<Charge>();
		vectors = new ArrayList<Vector>();
		for(int i = 25; i < 1000; i += 25){
   			for ( int j = 25; j < 1000; j += 25){
    			vectors.add( new Vector( i , j));
    		}	
    	}
		views = new ArrayList<SimulatorView>();
	}
	public ArrayList getCharges(){
		return charges;
	}
	
	public ArrayList getVectors(){
		return vectors;
	}
	
	public void updateVectors(){
	 	for(int i = 0; i < vectors.size(); i++){
	 		
    		Vector vtmp = new Vector();
    		Vector v = vectors.get(i);
    		for( int k = 0; k < charges.size(); k++){
    			vtmp = Vector.vectorSum(vtmp, ((Charge)(charges.get(k))).calculateElectricField(vectors.get(i)));
    		}
    		v.setTeta(vtmp.getTeta());
    		vectors.set(i,v);	
    	}
	}

	
	public void addCharge( Charge c){
		charges.add( c);
		updateVectors();
		notifyViews();
	}
	public void update(){//updating view
		for (int i = 0; i < views.size(); i++){
			views.get(i).updateView( this);
		}
	}
	public void addView( SimulatorView view)
	{
		views.add( view);
		if ( view != null)
			view.updateView( this);
	}

	public void notifyViews()
	{
		if ( views != null)
			for ( SimulatorView view : views)
				view.updateView( this);
	}
	public void deleteCharges(){
		for( int i = 0; i < charges.size(); i++){
			if( charges.get(i).getDelete() == true){
				charges.remove(i);
				i--;
			}
		}
		updateVectors();
		notifyViews();
	}
	public int getSelectedDelete(){
		int num = 0;
    	for( int i = 0; i < charges.size(); i++){
    		if( charges.get(i).getDelete() == true)
    			num++;
    	}
    	return num;
	}
	
	public void moveCharges( double x, double y){
		for( int i = 0; i < charges.size(); i++){
			if( charges.get(i).getMove() == true){
				charges.get(i).setLocation( x,y);
			}
		}
		updateVectors();
		notifyViews();
	}
	public void reset(){
		charges = new ArrayList<Charge>();
		notifyViews();
	}
}
