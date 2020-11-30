package User_interface;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import Data_control.DataController;

public class UIManager {
	private static Homepage homepage;
	private static CancellationPage cancelpage;
	private static RegisterForm registerpage;
	private static LoginPage loginpage;
	private static MoviePage moviepage;
	private static UIManager singleInstance;
	
	private UIManager() {
		homepage = new Homepage();
		cancelpage= new CancellationPage();
		registerpage = new RegisterForm();
		loginpage = new LoginPage();
	}
	
	public static UIManager getUIManager() {
		if (singleInstance==null) {
			singleInstance= new UIManager();
		}
		return singleInstance;
	}
	public void openHomepage() {
		homepage.setVisible(true);
		addListenersToHome();
	}
	
	public void closeHomepage() {
		homepage.closeHomepage();
	}
	
	public void openCancelPage() {
		cancelpage.setVisible(true);
		addListenersToCancel();
	}
	
	public void closeCancelPage() {
		cancelpage.setVisible(false);
		cancelpage.dispose();
	}
	
	public void openRegisterForm() {
		registerpage.setVisible(true);
		addListenersToRegister();
	}
	
	public void closeRegisterForm() {
		registerpage.setVisible(false);
		registerpage.dispose();
	}
	
	public void openLogin() {
		loginpage.setVisible(true);
		addListenersToLogin();
	}
	
	public void closeLogin() {
		loginpage.setVisible(false);
		loginpage.dispose();
	}
	
	public void openMoviePage() {
		if (moviepage==null) {
			moviepage = new MoviePage();
		}
		else {
			closeMoviePage();
			moviepage = new MoviePage();
		}
		moviepage.setVisible(true);
		addListenersToPurchase();
	}
	
	public void closeMoviePage() {
		moviepage.setVisible(false);
		moviepage.dispose();
	}
	
	public boolean registeredUser() {
		return homepage.getRegisteredUser();
	}
	public void addListenersToHome(){
		homepage.addCancelTicketListener(new navigateHomeToCancel());
		homepage.addRegisterListener(new navigateHomeToRegister());
		homepage.addLoginListener(new navigateHomeToLogin());
		homepage.addPurchaseTicketListener(new navigateHomeToMovie());
	}
	
	public void addListenersToRegister() {
		registerpage.addBackListener(new navigateRegisterToHome());
		registerpage.addLoginListener(new navigateRegisterToLogin());
	}
	
	public void addListenersToLogin() {
		loginpage.addBackListener(new navigateLoginToHome());
		loginpage.addRegisterListener(new navigateLoginToRegister());
	}
	
	public void addListenersToPurchase() {
		moviepage.addBackListener(new navigateMovieToHome());
		
	}
	
	public void addListenersToCancel() {
		cancelpage.addBackListener(new navigateCancelToHome());
	}
	
	public void setUsername(String username) {
		homepage.setUsername(username);
	}
	
	public String getUsername() {
		return homepage.getUsername();
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
	
	public class navigateHomeToLogin implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			closeHomepage();
			openLogin();
		}
	}
	
	public class navigateRegisterToHome implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			closeRegisterForm();
			openHomepage();
		}
	}
	
	public class navigateLoginToHome implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			closeLogin();
			openHomepage();
		}
	}
	
	public class navigateLoginToRegister implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			closeLogin();
			openRegisterForm();
		}
	}
	
	public class navigateRegisterToLogin implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			closeRegisterForm();
			openLogin();
		}
	}
	
	public class navigateHomeToMovie implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			closeHomepage();
			openMoviePage();
		}
	}
	
	public class navigateMovieToHome implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			closeMoviePage();
			openHomepage();
		}
	}
	
	public class navigateCancelToHome implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			closeCancelPage();
			openHomepage();
		}
	}
	

	public static void main(String[] args) {
		UIManager uiManager = UIManager.getUIManager();
		uiManager.openHomepage();
	}
}
