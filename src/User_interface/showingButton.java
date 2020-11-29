package User_interface;

import javax.swing.JButton;

import Theatre_elements.Showing;

public class showingButton extends JButton{
	private Showing show;
	
	public showingButton(Showing show, String label) {
		this.show=show;
		this.setLabel(label);
	}
	
	public Showing getShowing() {
		return show;
	}
	
}
