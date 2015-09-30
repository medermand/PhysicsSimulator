package physics.simulator.electrostatic;


public class Simulator {
	
	/**
	 * Method main
	 *
	 *
	 * @param args
	 *
	 */
	public static void main(String[] args) {
		SimulatorModel s = new SimulatorModel();
		
		Controls con = new Controls(s);
		SimGUI gui = new SimGUI(s);
		
		s.addView(con);
		s.addView(gui);
		SimulatorFrame frame = new SimulatorFrame( "Simulator", gui, con);
		
	}	
}
