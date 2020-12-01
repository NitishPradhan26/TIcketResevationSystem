package User_interface;

import javax.swing.JButton;

import Theatre_elements.Showing;

/**
 * Extends JButton class to store showing associated with button
 * @author Vic (Vu) Phan, Alex Price, Nitish Pradhan, Luka Petrovic
 *
 */
public class showingButton extends JButton{
	/**
	 * showing associated with button
	 */
	private Showing show;
	
	/**
	 * constructs button 
	 * @param show: associated showing 
	 * @param label: time label for button 
	 */
	public showingButton(Showing show, String label) {
		this.show=show;
		this.setLabel(label);
	}
	
	/**
	 * returns showing associated with button
	 * @return show: Showing
	 */
	public Showing getShowing() {
		return show;
	}
	
}
