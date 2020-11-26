package User_interface;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UIManager {
	private Homepage homepage;
	private CancellationPage cancelpage;
	private RegisterForm registerpage;
	
	public UIManager() {
		homepage = new Homepage();
		cancelpage= new CancellationPage();
		registerpage = new RegisterForm();
	}
	
	public void start() {
		homepage.setVisible(true);
		addListenersToHome();
	}
	
	public void closeHomepage() {
		homepage.closeHomepage();
	}
	
	public void openCancelPage() {
		cancelpage.setVisible(true);
	}
	
	public void openRegisterForm() {
		registerpage.setVisible(true);
	}
	
	public void addListenersToHome(){
		homepage.addCancelTicketListener(new navigateHomeToCancel());
		homepage.addRegisterListener(new navigateHomeToRegister());
	}
	
	public class navigateHomeToCancel implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			closeHomepage();
			openCancelPage();
		}
	}
	
	public class navigateHomeToRegister implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			closeHomepage();
			openRegisterForm();
		}
	}
	
	public static void main(String[] args) {
		UIManager uiManager = new UIManager();
		uiManager.start();
	}
}
